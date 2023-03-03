package com.example.demo.entity;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ExternalJSONUserParserImpl implements ExternalJSONUserParser {
    protected Map<String, FieldParser2> parsers;
    private static ExternalJSONUserParserImpl instance = null;

    private static Map<String, Object> fields = new HashMap<>();
    protected static final FieldParser2 defaultParser = ((fields, object) -> {
        String key = (String) object.keys().next();
        fields.put(key, object.getString(key));
    });
    protected static final FieldParser2 nestedParser = ((fields, object) -> {
        String key = (String) object.keys().next();
        fields.put(key, object.getJSONArray(key));
    });

    protected static final FieldParser2 secondParser = ((fields, object) -> {
        fields.put("key", "val");
    });

    public ExternalJSONUserParserImpl() {
        this.parsers = new HashMap<>();
        this.addDefaultParsers();
    }

    public static ExternalJSONUserParserImpl getInstance(){
        if (instance == null){
            instance = new ExternalJSONUserParserImpl();
        }
        return instance;
    }

    protected void addDefaultParsers() {
        parsers.put("firstName", defaultParser);
        parsers.put("middleName", defaultParser);
        parsers.put("lastName", defaultParser);
        parsers.put("bankAccounts", nestedParser);

    }
    protected void addParser(String key, FieldParser2 parser){
        this.parsers.put(key, parser);
    }

    @Override
    public ExternalUserTransaction parseExternalJsonTransaction(JSONObject request) throws JSONException {
        if (request == null){
            throw new JSONRequestException("request is null");
        }
//        return getParserInstance().parse(request);

        ExternalJSONUserParserImpl parser = getInstance();
        ExternalUserTransaction transaction = parser.parse(request);
        return transaction;

    }

    public ExternalUserTransaction parse(JSONObject request) throws JSONException {
        ExternalUserTransaction transaction = new ExternalUserTransaction();
        Map<String, Object> parsedFields = new HashMap<>();
        for(String key : parsers.keySet()){
            Object value = request.opt(key);
            if (value != null){
                JSONObject obj = new JSONObject();
                obj.put(key, value);
                parsers.get(key).parseField(fields, obj);
            }
        }
        parsedFields = fields;
        transaction.parsedFields = parsedFields;
        return transaction;
    }

    @FunctionalInterface
    public interface FieldParser<T>{
        String parse(JSONObject request) throws JSONException;
    }

    @FunctionalInterface
    public interface FieldParser2{
        void parseField(Map<String, Object> fields, JSONObject node) throws JSONException;
    }
}

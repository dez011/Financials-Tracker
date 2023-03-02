package com.example.demo.entity;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ExternalJSONUserParserImpl implements ExternalJSONUserParser {
    private Map<String, Object> fields = new HashMap<>();
    protected static final FieldParser2 defaultParser = ((fields, node) -> {
        fields.put(node.getString("firstName"), "");
    });
    @Override
    public ExternalUserTransaction parseExternalJsonTransaction(JSONObject request) throws JSONException {
        if (request == null){
            throw new JSONRequestException("request is null");
        }


        return getParserInstance().parse(request);
    }

    public JSONUserParser getParserInstance() {
        Map<String, FieldParser<?>> parsers = new HashMap<>();
        parsers.put("firstName", request -> {
            return request.getString("firstName");
        });

//        Map<String, FieldParser2> parsers2 = new HashMap<>();
//        parsers.put("firstName", defaultParser);
        //parsers.put("SID", (fields, node) -> fields.put(node.getName(), StringUtils.leftPad(node.getValue(), 8, '0)));
        //parsers.put("ADL", defaultParser);

        return new JSONUserParser(parsers);
    }

    private static class JSONUserParser {
        private final Map<String, FieldParser<?>> parsers;

        private JSONUserParser(Map<String, FieldParser<?>> parsers) {
            this.parsers = parsers;
        }

        public ExternalUserTransaction parse(JSONObject request) throws JSONException {
            ExternalUserTransaction transaction = new ExternalUserTransaction();
            Map<String, String> parsedFields = new HashMap<>();
            for(String fieldName : parsers.keySet()){
                if (request.has(fieldName)){
                    FieldParser<?> parser = parsers.get(fieldName);
                    String fieldValue = parser.parse(request);
                    parsedFields.put(fieldName, fieldValue);
                }
            }
            transaction.parsedFields = parsedFields;
            return transaction;
        }
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

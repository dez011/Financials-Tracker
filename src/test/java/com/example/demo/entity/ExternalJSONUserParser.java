package com.example.demo.entity;

import org.json.JSONException;
import org.json.JSONObject;

public interface ExternalJSONUserParser {
    ExternalUserTransaction parseExternalJsonTransaction(JSONObject request) throws JSONException;
}

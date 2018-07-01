package com.example.deepankursadana.imageloading.interfaces;

import org.json.JSONObject;

public interface ApiResponseListener {

    void onSuccess(String key,String jsonObject);
    void onFailure();
}

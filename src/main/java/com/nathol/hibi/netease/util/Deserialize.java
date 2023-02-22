package com.nathol.hibi.netease.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

@SuppressWarnings("unused")
public class Deserialize {
    private static final Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public static <T> T deserialize(String json, Class<T> classOfT){
        return gson.fromJson(json, classOfT);
    }
    public static <T> T deserialize(JsonElement jsonElement, Class<T> classOfT){
        return gson.fromJson(jsonElement, classOfT);
    }
}

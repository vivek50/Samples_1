package com.example.gsonsample.web;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SingletonRequest {

    private static RequestQueue requestQueue;

    public static RequestQueue queue (Context context) {
        return requestQueue == null ? Volley.newRequestQueue(context) : requestQueue;
    }
}

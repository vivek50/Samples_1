package com.example.gsonsample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.toolbox.StringRequest;
import com.example.gsonsample.R;
import com.example.gsonsample.pojo.Example;
import com.example.gsonsample.web.SingletonRequest;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getGithubCommits();
    }

    private void getGithubCommits() {

        String URL = "https://api.github.com/repos/hadley/ggplot2/commits";

        SingletonRequest.queue(this).add(new StringRequest(URL, response -> {
            List<Example> example = new GsonBuilder().create().fromJson(response,
                    new TypeToken<List<Example>>(){}.getType());

            /*Another way data fetch from JSON*/
            /*List<Example> example = Arrays.asList(new GsonBuilder().create().fromJson(response,
                    Example[].class));*/

            setData(example);
        }, error -> Log.d("@modi","Error Response : " + error)));
    }

    private void setData(List<Example> data) {
        Log.d("@modi", String.valueOf(data.size()));
    }
}

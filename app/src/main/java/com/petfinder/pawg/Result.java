package com.petfinder.pawg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class sends the users query to the server. To test the application on android device then connect your server and android
 * device to the same ip address and write out your ip address in BASE_URL.
 * To test the application on android emulator just uncomment it and comment the other one.
 */
public class Result extends AppCompatActivity {

    public RecyclerView recyclerView;
    public MyAdapter adapter;
    TextView textView;

    //change the below ip address to "http://your ip address:8080/pawg/" if you are testing the application on real device
    //public static final String BASE_URL = "http://172.20.10.4:8080/pawg/";
    //OR
    //Use this ip address if you are testing application on android emulator DO NOT CHANGE IP ADDRESS just uncomment it and comment the above.
    public static final String BASE_URL = "http://10.0.2.2:8080/pawg/";
    public ApiCalls api;
    public List<Paws> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        Intent intent = getIntent();
        String query = intent.getStringExtra(Intent.EXTRA_TEXT);
        createPaws(query);
    }

    /**
     * This method takes the users query and performs post request method, gets the data from server and displays in the recyclerview.
     *
     * @param query takes input of the user.
     */
    private void createPaws(String query) {
        list = new ArrayList<>();

        //retrofit api is used for calling the API
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        api = retrofit.create(ApiCalls.class);

        Call<List<Paws>> call = api.createPaws(query);


        call.enqueue(new Callback<List<Paws>>() {
            @Override
            public void onResponse(Call<List<Paws>> call, Response<List<Paws>> response) {

                //displaying the result
                list = response.body();
                LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(manager);
                recyclerView.setHasFixedSize(true);
                adapter = new MyAdapter(list, getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Paws>> call, Throwable t) {
                Toast.makeText(Result.this, "Fail to Connect " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }

}

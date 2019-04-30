package com.petfinder.pawg;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * This interface is used to call the HTTP POST Request.
 */

public interface ApiCalls {

    @POST("query")
    Call<List<Paws>> createPaws(@Body String paws);

}

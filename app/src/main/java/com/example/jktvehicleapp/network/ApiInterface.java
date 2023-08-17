package com.example.jktvehicleapp.network;

import com.example.jktvehicleapp.modelClass.Register;

import java.util.HashMap;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiInterface {


    @POST(ApiConstants.REGISTER)
    Call<ResponseBody> register(@Body Register body );

    // "status": 1,
    //    "Message": "User created successfully"


//if params available
  //  @FormUrlEncoded
  //  @POST(ApiConstants.COMPANYINFO)
  //  Call<ResponseBody>getMemName(@FieldMap HashMap<String,String> mem);


//if get API
   // @GET(ApiConstants.COMPANYINFO)
   // Call<ResponseBody>getMemName(@QueryMap HashMap<String,String> mem);
}

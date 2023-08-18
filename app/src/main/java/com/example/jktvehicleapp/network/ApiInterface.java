package com.example.jktvehicleapp.network;

import com.example.jktvehicleapp.modelClass.Register;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {


    @POST(ApiConstants.REGISTER)
    Call<ResponseBody> register(@Body Register body );

    @POST(ApiConstants.LOGIN)
    Call<ResponseBody> login(@Body Register body );
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

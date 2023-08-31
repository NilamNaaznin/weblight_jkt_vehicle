package com.weblite.jktvehicleapp.network;

import com.weblite.jktvehicleapp.modelClass.Register;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiInterface {


    @POST(ApiConstants.REGISTER)
    Call<ResponseBody> register(@Body Register body);

    @POST(ApiConstants.LOGIN)
    Call<ResponseBody> login(@Body Register body);

    @Multipart
    @POST(ApiConstants.PROFILE_IMG + "/{id}")
    Call<ResponseBody> profileImageUpload(@Part MultipartBody.Part image, @Path(value="id", encoded=true) String id);

    @Multipart
    @POST(ApiConstants.AADHAAR_IMG + "/{id}")
    Call<ResponseBody> aadhaarImageUpload(@Part MultipartBody.Part image, @Path(value="id", encoded=true) String id);

/*    @POST(ApiConstants.UPDATE_NAME_PHONE + "/{id}")
    Call<ResponseBody> updateNamePhone(@Body Register body);*/



    @GET(ApiConstants.GET_PROFILE+"/{id}")
    Call<ResponseBody> getProfile(@Path("id") String id);

    @POST(ApiConstants.UPDATE_NAME_PHONE+"/{id}")
    Call<ResponseBody> updateNamePhone(@Body HashMap<String,String>map,@Path("id") String id);



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

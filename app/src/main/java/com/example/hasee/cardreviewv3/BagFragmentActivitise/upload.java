package com.example.hasee.cardreviewv3.BagFragmentActivitise;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface upload {
    @POST("/upload")
    @Multipart
    Call<ResponseBody> call(@Part MultipartBody.Part part);

}

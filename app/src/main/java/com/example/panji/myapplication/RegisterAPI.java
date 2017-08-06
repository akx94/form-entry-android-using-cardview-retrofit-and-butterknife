package com.example.panji.myapplication;

/**
 * Created by Panji on 05/08/2017.
 */
import retrofit2.Call;
import retrofit2.http.*;


public interface RegisterAPI {

    @FormUrlEncoded
    @POST("insert.php")
    Call<Value>daftar(@Field("npm")String npm,
                      @Field("nama")String nama,
                      @Field("kelas")String kelas,
                      @Field("sesi")String sesi);
    @GET("view.php")
    Call<Value>view();

}



package com.example.credisafe.api;

import com.example.credisafe.model.Individual;
import com.example.credisafe.model.Login;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PostApi {


    String root = "http://192.168.10.126:8000/";
//    String root = "http://127.0.0.1:8000/";


    String base_local = root + "api/v1/";
    String BASE_URL = base_local + "account/";
    String POST_URL = base_local + "post/";
    String API_URL = root + "api/v1/";


    

    @POST("api-token-auth/")
    Call<Individual> login(@Body Login login);

    @POST("register/")
    Call<Individual> registrationIndividual(@Body Individual userModel);


//    @GET("post/list/")
//    Call<List<PostModel>> getListPost();
//
//    @GET("post/{id}/")
//    Call<PostModel> getPost(@Path(value = "id", encoded = true) String id);
//
//    @POST("add/")
//    Call<PostModel> addPost(@Header("Authorization")  String authToken, @Body PostModel postModel);
////
//    @GET("profile/list/")
//    Call<List<PostModel>> getProfileList(@Header("Authorization")  String authToken);
//
//
//    @PUT("profile/edit/{id}/")
//    Call<PostModel> updatePost(@Header("Authorization")  String authToken, @Body PostModel postModelUpdate, @Path(value = "id", encoded = true) String id);
//
//
//    @DELETE("profile/delete/{id}/")
//    Call<List<PostModel>> deletePost(@Header("Authorization")  String authToken, @Path(value = "id", encoded = true) String id);
//
//
//    @GET("category/list/")
//    Call<List<CategoryModel>> getAllCategory();
//
//    @GET("list/{id}/")
//    Call<List<CategoryModel>> getCategoryById(@Path(value = "id", encoded = true) Integer id);

}
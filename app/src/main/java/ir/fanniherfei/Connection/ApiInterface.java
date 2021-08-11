package ir.fanniherfei.Connection;

import android.provider.ContactsContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
public interface ApiInterface {
    @FormUrlEncoded
    @POST("mohammad.aspx")
    Call<User> performLogin(@Field("username") String user, @Field("password") String pass);
}
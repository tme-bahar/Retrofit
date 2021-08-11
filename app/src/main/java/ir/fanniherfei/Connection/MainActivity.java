package ir.fanniherfei.Connection;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.stream.JsonReader;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        performLogin("usnm","pass");
        Log.i("onCreate","visit");
    }
    private void performLogin(String usrname, String pwd){
        Call<User> call =apiInterface.performLogin(usrname,pwd);
        Log.i("performLogin","before run");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.i("performLogin","run");
                Log.i("result1",response.body().getResponse());
                Log.i("result2",response.body().getResponse2());
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                //display errror message
                Log.i("performLogin","failed because : "+t.getMessage());
            }
        });
    }

}
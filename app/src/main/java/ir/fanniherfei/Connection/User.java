package ir.fanniherfei.Connection;

import com.google.gson.annotations.SerializedName;
public class User {
    @SerializedName("url")
    private String Response;

    @SerializedName("post username")
    private String Response2;

    public String getResponse() {
        return Response;
    }

    public String getResponse2() {
        return Response2;
    }
}
package com.example.myapplication.transfer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class sendReport {
    //获取report信息
    private String userName1;
    private String location1;
    private String time1;
    private String message1;
    private String photo1;

    public String getPhoto() {return photo1; }
    public String getUserName(){
        return userName1;
    }
    public String getTime(){
        return time1;
    }
    public String getStatusCode(){
        return location1;
    }
    public String getMessage(){
        return message1;
    }
    public sendReport(String userName, String location, String time, String message,String photo) {
        this.photo1=photo;
        this.userName1=userName;
        this.location1=location;
        this.time1=time;
        this.message1=message;

//            HttpURLConnection urlConnection = null;
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        JSONObject json = new JSONObject();
        try {
            json.put("username", userName1);
            json.put("location", location1);
            json.put("time", time1);
            json.put("message", message1);
            json.put("photo",photo1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON, String.valueOf(json));
        System.out.println("REQUEST BODY:" + requestBody);

        String format = String.format("http://10.19.42.253:5000/report/create_report");
        Request request = new Request.Builder()
                .url(format)
                .post(requestBody)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFF");
                //DialogUtils.showPopMsgInHandleThread(Release_Fragment.this.getContext(), mHandler, "数据获取失败，请重新尝试！");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String Mstring = response.body().string();

            }
        });

    }
}

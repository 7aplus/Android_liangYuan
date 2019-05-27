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

public class uploadUser {
    //获取report信息
    private String userName1;
    private String phone1;
    private String email1;
    private String firstName1;
    private String lastName1;
    private String country1;
    private String password1;

    public uploadUser(String userName, String phone, String email, String firstName,String lastName,String country,String password) {
        this.phone1=phone;
        this.userName1=userName;
        this.email1=email;
        this.firstName1=firstName;
        this.lastName1=lastName;
        this.country1=country;
        this.password1=password;

//            HttpURLConnection urlConnection = null;
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        JSONObject json = new JSONObject();
        try {
            json.put("name", userName1);
            json.put("phone", phone1);
            json.put("email", email1);
            json.put("firstName",firstName1);
            json.put("lastName",lastName1);
            json.put("country",country1);
            json.put("password",password1);
            json.put("type","user");
            System.out.println(firstName1+"WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON, String.valueOf(json));
        System.out.println("REQUEST BODY:" + requestBody);

        String format = String.format("http://10.19.42.253:5000/account/update_account_details");
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

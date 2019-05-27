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

public class getInfor1 {
    //获取个人信息
    private String userName1;
    private String phone1;
    private String email1;
    private String firstName1;
    private String lastName1;
    private String country1;
    private String password1;

    public String getFirstName() { return firstName1; }
    public String getLastName() { return lastName1; }
    public String getCountry() { return country1; }
    public String getPassword() { return password1; }
    public String getUserName(){
        return userName1;
    }
    public String getPhone(){
        return phone1;
    }
    public String getEmail(){
        return email1;
    }

    public getInfor1(String userName) {
        this.userName1=userName;

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        JSONObject json = new JSONObject();
        try {
            json.put("name", userName);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON, String.valueOf(json));
        System.out.println("REQUEST BODY:" + requestBody);

        String format = String.format("http://10.19.42.253:5000/account/get_someone_details");
        //发送请求
        Request request = new Request.Builder()
                .url(format)
                .post(requestBody)
                .build();

        try {
            Response response=okHttpClient.newCall(request).execute();
            //获取到数据
            String Mstring=response.body().string();
            try {
                JSONObject jsonObject = new JSONObject(Mstring);
                firstName1 = jsonObject.getString("firstName");
                lastName1 = jsonObject.getString("lastName");
                country1 = jsonObject.getString("country");
                password1 = jsonObject.getString("password");
                phone1 = jsonObject.getString("phone");
                email1 = jsonObject.getString("email");
            }catch (JSONException e){
                System.out.println("Wrong");
            }
            //把数据传入解析josn数据方法

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFF");
                //DialogUtils.showPopMsgInHandleThread(Release_Fragment.this.getContext(), mHandler, "数据获取失败，请重新尝试！");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String Mstring = response.body().string();
                if (Mstring != null) {
                    try {
                        JSONObject jsonObject = new JSONObject(Mstring);

                         phone1 = jsonObject.getString("phone");
                         email1 = jsonObject.getString("email");
                    } catch (JSONException e) {
                        System.out.println("EEEEEEEEEEEEEEEE");
                    }
                }
            }
        });

    }
}

package com.example.myapplication.transfer;

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

public class check {
    //    检测用户名密码
    private String userName;
    private String passWord;
    private String myfinaltest;
    private String status;
    private String test="0";

    //获取用户名
    public String getUserName(){
        return userName;
    }
    //获取密码
    public String getPassWord(){
        return passWord;
    }
    //获取登录状态码
    public String getStatus(){
        return status;
    }


    public check(String userName,String passWord) {

        System.out.print("userName " + userName);
        System.out.print("userpass " + passWord);
        //            HttpURLConnection urlConnection = null;
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        JSONObject json = new JSONObject();
        try {
            json.put("type", "customer");
            json.put("name", userName);
            json.put("password", passWord);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON, String.valueOf(json));
        System.out.println("REQUEST BODY:" + requestBody);
        String format = String.format("http://10.19.42.253:5000/account/login");
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
                status = jsonObject.getString("status_code");
            }catch (JSONException e){
                System.out.println("Wrong");
            }
            //把数据传入解析josn数据方法

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"+status);

        Callback callback=new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFF");
                //DialogUtils.showPopMsgInHandleThread(Release_Fragment.this.getContext(), mHandler, "数据获取失败，请重新尝试！");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String Mstring = response.body().string();
                System.out.println("BBBBBBBBBBBBBBBBB" + Mstring);
                if (Mstring != null) {
                    try {
                        JSONObject jsonObject = new JSONObject(Mstring);
                        status= jsonObject.getString("status_code");
                        System.out.println(status+"woyishi");

                        myfinaltest = status;

                    } catch (JSONException e) {
                        System.out.println("EEEEEEEEEEEEEEEE");
                    }

                } else {
                    myfinaltest = "wrong";
                }
            }
        };

        okHttpClient.newCall(request).enqueue(callback);


    }

}

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

public class getReport {
    //获取report信息
    private String userName1;
    private String[] location1=new String[99];
    private String[] time1=new String[99];
    private int[] orderId1=new int [99];
    private int[] statusCode1=new int[99];
    private String[] feedback1=new String[99];
    private int length;

    public String getUserName() {
        return userName1;
    }

    public int getLength() {
        return length;
    }

    public String[] getLocation() {
        return location1;
    }

    public String[] getTime() {
        return time1;
    }

    public int[] getOrderId() {
        return orderId1;
    }

    public int[] getStatusCode() {
        return statusCode1;
    }

    public String[] getFeedback() {
        return feedback1;
    }

    public getReport(String userName) {
        System.out.print("userNAme " + userName);
//            HttpURLConnection urlConnection = null;
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        JSONObject json = new JSONObject();
        try {
            json.put("username", userName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        JSONObject json2 = new JSONObject();
//        try {
//            json2.put("username", "user_name1");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON, String.valueOf(json));
        System.out.println("REQUEST BODY:" + requestBody);
        String type = "customer";
        String format = String.format("http://10.19.42.253:5000/report/get_someone_report");
        Request request = new Request.Builder()
                .url(format)
                .post(requestBody)
                .build();



        try {
            Response response = okHttpClient.newCall(request).execute();
            //获取到数据
            String Mstring = response.body().string();
            try {
                JSONObject jsonObject = new JSONObject(Mstring);

                String status = jsonObject.getString("status_code");
                System.out.println("status is :" + status);
                JSONArray resultJsonArray = jsonObject.getJSONArray("reports");
                length = resultJsonArray.length();
                System.out.println("length" + resultJsonArray.length());
                for (int i = 0; i < resultJsonArray.length(); i++) {
                    JSONObject jo = resultJsonArray.getJSONObject(i);
                    String t=jo.getString("time");
                    String l=jo.getString("location");
                    int s= jo.getInt("status");
                    int o = jo.getInt("orderId");
                    time1[i]=t;
                    orderId1[i]=o;
                    statusCode1[i]=s;
                    location1[i]=l;
//                    System.out.println(time1[i]);
//                    System.out.println(jo.getInt("orderId"));
//                    System.out.println(jo.getInt("status"));
//                    System.out.println("worinigeAAAAAAAAAAAAAAAAAAAAAA");
//                    location1[i] = jo.getString(" location");
//                    orderId1[i] = jo.getInt("orderId");
//                    statusCode1[i] = jo.getInt("status");
//                    time1[i] = jo.getString("time");
//                    System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
//                    System.out.println(orderId1[i]+"worinigeaaaaaaaaaaaaaaaaaaaaaaaaaa");
                    if (jo.get("feedback") instanceof String) {
                        String f0="no feedback";
                        feedback1[i] = f0;
                    } else {
                        String f1=jo.getString("feedback");
                        feedback1[i] = f1;
                    }

                }

            } catch (JSONException e) {
                System.out.println("EEEEEEEEEEEEEEEE");
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

            }
        });
    }
}
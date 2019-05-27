package com.example.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;

import android.os.Build;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.myapplication.transfer.check;
import com.example.myapplication.transfer.getInfor1;
import com.example.myapplication.transfer.getReport;

public class start extends AppCompatActivity implements View.OnClickListener{

    private Button login;
    private Button translateEN;
    private Button translateZH;
    private EditText phone;
    private EditText password;
    public static final String use="username";
    public static final String length1="length";
    public static final String phone1="phone";
    public static final String email1="email";
    public static final String location1="location";
    public static final String time1="time";
    public static final String statusCode1="status";
    public static final String orderId1="orderId";
    public static final String feedback1="feedback";
    public static final String firstName1="firstName";
    public static final String lastName1="lastName";
    public static final String country1="country";
    public static final String password2="password";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        login = this.findViewById(R.id.Login);

//        translateEN = this.findViewById(R.id.TranslateEN);
//        translateZH = this.findViewById(R.id.TranslateZH);
        findViewById(R.id.TranslateEN).setOnClickListener(this);
        findViewById(R.id.TranslateZH).setOnClickListener(this);
        password=findViewById(R.id.Password);
//        phone=findViewById(R.id.Phone);

        phone = findViewById(R.id.Phone);
        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String phoneStr = s.toString();
                boolean b = isPhoneNumber(phoneStr);
                if (b) {
                    phone.setTextColor(Color.rgb(0, 255, 0));
                } else {
                    phone.setTextColor(Color.rgb(255, 0, 0));
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(start.this, MainActivity.class);
                startActivity(i);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String userName = phone.getText().toString();
                final String passWord = password.getText().toString();
                String phone = "";
                String email = "";
                System.out.println("start check");
                //改的时候把这段标注掉dldldldldld
                final Thread thread = new Thread(){
                    @Override
                    public void run(){
                        check check=new check(userName,passWord);
                        getInfor1 gf=new getInfor1(userName);
                        getReport gr=new getReport((userName));
                        //登录码
                        String status=check.getStatus();
                        //个人信息
                        String phone=gf.getPhone();
                        String email=gf.getEmail();
                        String first=gf.getFirstName();
                        String last=gf.getLastName();
                        String country=gf.getCountry();
                        String passwordd=gf.getPassword();

                        //report 列表
                        String[] location=gr.getLocation();
                        String[] time=gr.getTime();
//                        System.out.println("timeworinigr"+gr.getTime()[0]);
                        int[] orderId=gr.getOrderId();
                        int[] statusCode=gr.getStatusCode();
                        String[] feedback=gr.getFeedback();
                        int length=gr.getLength();

                        //判断登录码
                            if (status.equals("100211")) {
                            Intent i = new Intent(start.this,MainActivity.class);
                            i.putExtra(use,userName);

                            i.putExtra(phone1,phone);
                            i.putExtra(email1,email);
                            i.putExtra(firstName1,first);
                            i.putExtra(lastName1,last);
                            i.putExtra(country1,country);
                            i.putExtra(password2,passwordd);


                            i.putExtra(length1,length);
                            i.putExtra(location1,location);
                            i.putExtra(time1,time);
                            i.putExtra(orderId1,orderId);
                            i.putExtra(statusCode1,statusCode);
                            i.putExtra(feedback1,feedback);

                            startActivity(i);
                        }else if(status.equals("100220")||status.equals("100210")) {
                                Looper.prepare();
                                AlertDialog.Builder builder = new AlertDialog.Builder(start.this);
                                builder.setTitle(R.string.t);
                                builder.setMessage(R.string.loginfail);
                                builder.setPositiveButton(R.string.yes, null);
                                builder.show();
                                Looper.loop();

//                                try {
//                                    Thread.sleep(1000);
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
                        }else if(status.equals("100200")) {
                                Looper.prepare();
                                AlertDialog.Builder builder = new AlertDialog.Builder(start.this);
                                builder.setTitle(R.string.t);
                                builder.setMessage("login fail! Unknown fault");
                                builder.setPositiveButton(R.string.yes, null);
                                builder.show();
                                Looper.loop();
                            }

                    }

                };

                thread.start();
//没错就是这段我是结尾dldldldldld然后把下面这个intent开了
//                Intent i = new Intent(start.this,MainActivity.class);
//                startActivity(i);
            }
        });


    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.TranslateZH:
                changeAppLanguage(Locale.SIMPLIFIED_CHINESE);
                break;
            case R.id.TranslateEN:
                changeAppLanguage(Locale.TRADITIONAL_CHINESE);
                break;
//            case R.id.us_btn:
//                changeAppLanguage(Locale.US);
//                break;
//            case R.id.jp_btn:
//                changeAppLanguage(Locale.JAPAN);
//                break;
            default:
                break;
        }
    }
    public void changeAppLanguage(Locale locale) {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        Configuration configuration = getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
        getResources().updateConfiguration(configuration, metrics); //重新启动Activity
        Intent intent = new Intent(this, start.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

//
    private boolean isPhoneNumber(String phoneStr) {
//        String regex = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        String regex = "^(\\w+)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phoneStr);
        return m.find();
    }

//^((13[0-9])|(15[^4,\D])|(18[0,5-9]))\d{8}$
    ///^(\+?0?86\-?)?1[345789]\d{9}$/


}
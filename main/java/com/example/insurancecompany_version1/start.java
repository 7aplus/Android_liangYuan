package com.example.insurancecompany_version1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class start extends AppCompatActivity {

    private Button login;
    private Button translateEN;
    private Button translateZH;
    private EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        login = this.findViewById(R.id.Login);
        translateEN = this.findViewById(R.id.TranslateEN);
        translateZH = this.findViewById(R.id.TranslateZH);

        phone=findViewById(R.id.Phone);
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
                Intent i = new Intent(start.this,MainActivity.class);
                startActivity(i);
            }
        });
        translateEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        translateZH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }

    private boolean isPhoneNumber(String phoneStr) {
        String regex = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phoneStr);
        return m.find();
    }
//^((13[0-9])|(15[^4,\D])|(18[0,5-9]))\d{8}$
    ///^(\+?0?86\-?)?1[345789]\d{9}$/
}
package com.example.myapplication.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class fragment3_detail extends AppCompatActivity {
    String username="user_name1";
    String password="1234567";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment3_detail);

        TextView Detail_name = findViewById(R.id.Detail_name);
        TextView Detail_name_input = findViewById(R.id.Detail_name_input);
        TextView Detail_number = findViewById(R.id.Detail_number);
        TextView Detail_number_input = findViewById(R.id.Detail_number_input);
        TextView Detail_date = findViewById(R.id.Detail_date);
        TextView Detail_date_input = findViewById(R.id.Detail_date_input);
        TextView Detail_phone = findViewById(R.id.Detail_phone);
        TextView Detail_phone_input = findViewById(R.id.Detail_phone_input);
        TextView Detail_type = findViewById(R.id.Detail_type);
        TextView Detail_type_input = findViewById(R.id.Detail_type_input);
        TextView Detail_feedback = findViewById(R.id.Detail_feedback);
        TextView Detail_feedback_input = findViewById(R.id.Detail_feedback_input);
        TextView Detail_detail = findViewById(R.id.Detail_detail);
        TextView Detail_detail_input = findViewById(R.id.Detail_detail_input);
        TextView Detail_assistant=findViewById(R.id.Detail_assistant);


        Detail_name.setText(R.string.name);
        Detail_name_input.setText(getIntent().getStringExtra("nameinput"));
        Detail_number.setText(R.string.number);
        Detail_number_input.setText("111");
        Detail_date.setText(R.string.timeof);
        Detail_date_input.setText(getIntent().getStringExtra("dateinput"));
        Detail_phone.setText(R.string.phone);
        Detail_phone_input.setText("13113816283");
        Detail_type.setText(R.string.location);
        Detail_type_input.setText(getIntent().getStringExtra("locationinput"));
        Detail_feedback.setText(R.string.fragment3_item_feedback);
        Detail_feedback_input.setText(getIntent().getStringExtra("feedbackinput"));
        Detail_detail.setText(R.string.detail);
        Detail_detail_input.setText(getIntent().getStringExtra("detailinput"));
        Detail_assistant.setText(R.string.assistant);

    }
}

package com.example.insurancecompany_version1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class fragment3_detail extends AppCompatActivity {

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

        Detail_name.setText(getIntent().getStringExtra("name"));
        Detail_name_input.setText(getIntent().getStringExtra("nameinput"));
        Detail_number.setText(getIntent().getStringExtra("number"));
        Detail_number_input.setText(getIntent().getStringExtra("numberinput"));
        Detail_date.setText(getIntent().getStringExtra("date"));
        Detail_date_input.setText(getIntent().getStringExtra("dateinput"));
        Detail_phone.setText(getIntent().getStringExtra("phone"));
        Detail_phone_input.setText(getIntent().getStringExtra("phoneinput"));
        Detail_type.setText(getIntent().getStringExtra("type"));
        Detail_type_input.setText(getIntent().getStringExtra("typeinput"));
        Detail_feedback.setText(getIntent().getStringExtra("feedback"));
        Detail_feedback_input.setText(getIntent().getStringExtra("feedbackinput"));
        Detail_detail.setText(getIntent().getStringExtra("detail"));
        Detail_detail_input.setText(getIntent().getStringExtra("detailinput"));

    }
}

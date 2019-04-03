package com.example.insurancecompany_version1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class fragment2_report extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment2_report);

        Button Report_button_submit = findViewById(R.id.Report_button_submit);
        Report_button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Submit", Toast.LENGTH_SHORT).show();
                fragment2_report.this.finish();
            }
        });

        TextView Report_info_name = findViewById(R.id.Report_info_name);
        TextView Report_info_name_input = findViewById(R.id.Report_info_name_input);
        TextView Report_info_number = findViewById(R.id.Report_info_number);
        TextView Report_info_number_input = findViewById(R.id.Report_info_number_input);
        TextView Report_info_date = findViewById(R.id.Report_info_date);
        TextView Report_info_date_input = findViewById(R.id.Report_info_date_input);
        TextView Report_info_phone = findViewById(R.id.Report_info_phone);
        TextView Report_info_phone_input = findViewById(R.id.Report_info_phone_input);
        TextView Report_info_type = findViewById(R.id.Report_info_type);
        TextView Report_info_type_input = findViewById(R.id.Report_info_type_input);
        TextView Report_form_date = findViewById(R.id.Report_form_date);
        TextView Report_form_time = findViewById(R.id.Report_form_time);
        TextView Report_form_location = findViewById(R.id.Report_form_location);
        TextView Report_form_detail = findViewById(R.id.Report_form_detail);

//        EditText Report_form_date_input = findViewById(R.id.Report_form_date_input);
//        EditText Report_form_time_input = findViewById(R.id.Report_form_time_input);
//        EditText Report_form_location_input = findViewById(R.id.Report_form_location_input);

        Report_info_name.setText(getIntent().getStringExtra("name"));
        Report_info_name_input.setText(getIntent().getStringExtra("nameinput"));
        Report_info_number.setText(getIntent().getStringExtra("number"));
        Report_info_number_input.setText(getIntent().getStringExtra("numberinput"));
        Report_info_date.setText(getIntent().getStringExtra("date"));
        Report_info_date_input.setText(getIntent().getStringExtra("dateinput"));
        Report_info_phone.setText(getIntent().getStringExtra("phone"));
        Report_info_phone_input.setText(getIntent().getStringExtra("phoneinput"));
        Report_info_type.setText(getIntent().getStringExtra("type"));
        Report_info_type_input.setText(getIntent().getStringExtra("typeinput"));
        Report_form_date.setText(getIntent().getStringExtra("dateform"));
        Report_form_time.setText(getIntent().getStringExtra("timeform"));
        Report_form_location.setText(getIntent().getStringExtra("locationform"));
        Report_form_detail.setText(getIntent().getStringExtra("detailform"));


    }
}

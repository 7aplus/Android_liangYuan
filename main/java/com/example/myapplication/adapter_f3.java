package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.fragment.notification_f3;

public class adapter_f3 extends BaseAdapter {
    private Context context = null;
    private Intent intent = null;
    private com.example.myapplication.fragment.notification_f3[] notification_f3;

    public adapter_f3(Context context, Intent intent, notification_f3[] notification_f3) {
        this.context = context;
        this.intent = intent;
        this.notification_f3 = notification_f3;
    }

    public Context getContext() {
        return context;
    }

    public Intent getIntent() {
        return intent;
    }

    public void startActivity() {
        this.context.startActivity(getIntent());
    }

    @Override
    public int getCount() {
        return notification_f3.length;
    }

    @Override
    public notification_f3 getItem(int site) {
        return notification_f3[site];
    }

    @Override
    public long getItemId(int site) {
        return site;
    }

    @Override
    public View getView(int site, View convertView, ViewGroup parent) {

        LinearLayout ll_f3 = null;

        if (convertView != null) {
            ll_f3 = (LinearLayout) convertView;
        } else {
            ll_f3 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.fragment3_listitem, null);
        }

        notification_f3 notification_f3 = getItem(site);

        TextView fragment3_item_date_input = ll_f3.findViewById(R.id.fragment3_item_date_input);
        TextView fragment3_item_name_input = ll_f3.findViewById(R.id.fragment3_item_name_input);
        TextView fragment3_item_feedback = ll_f3.findViewById(R.id.fragment3_item_feedback);
        TextView fragment3_item_feedback_input = ll_f3.findViewById(R.id.fragment3_item_feedback_input);
        ImageView fragment3_item_image = ll_f3.findViewById(R.id.fragment3_item_image);
////        EditText Report_form_date_input = ll_f2.findViewById(R.id.Report_form_date_input);
////        EditText Report_form_time_input = ll_f2.findViewById(R.id.Report_form_time_input);
////        EditText Report_form_location_input = ll_f2.findViewById(R.id.Report_form_location_input);
//
//        //Set the picture and text
        fragment3_item_date_input.setText(notification_f3.getFragment3_item_date_input());
        fragment3_item_name_input.setText(notification_f3.getFragment3_item_name_input());
        fragment3_item_feedback.setText(notification_f3.getFragment3_item_feedback());
        fragment3_item_feedback_input.setText(notification_f3.getFragment3_item_feedback_input());
        fragment3_item_image.setImageResource(notification_f3.getFragment3_item_image());


        return ll_f3;
    }
}

package com.example.insurancecompany_version1;

import android.content.Context;
import android.content.Intent;
import android.widget.BaseAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.ImageView;

public class adapter_f2 extends BaseAdapter {

    private Context context = null;
    private Intent intent = null;
    private myinsurance_f2[] fragment2_info;

    public adapter_f2(Context context, Intent intent, myinsurance_f2[] fragment2_info) {
        this.context = context;
        this.intent = intent;
        this.fragment2_info = fragment2_info;
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
        return fragment2_info.length;
    }

    @Override
    public myinsurance_f2 getItem(int site) {
        return fragment2_info[site];
    }

    @Override
    public long getItemId(int site) {
        return site;
    }

    @Override
    public View getView(int site, View convertView, ViewGroup parent) {

        LinearLayout ll_f2 = null;

        if (convertView != null) {
            ll_f2 = (LinearLayout) convertView;
        } else {
            ll_f2 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.fragment2_listitem, null);
        }

        myinsurance_f2 myinsurance_f2 = getItem(site);

//        TextView fruitName = (TextView) ll_f2.findViewById(R.id.fruitName);
//        ImageView icon = (ImageView) ll_f2.findViewById(R.id.icon);

        TextView fragment2_item_date_input = ll_f2.findViewById(R.id.fragment2_item_date_input);
        TextView fragment2_item_date = ll_f2.findViewById(R.id.fragment2_item_date);
        TextView fragment2_item_name = ll_f2.findViewById(R.id.fragment2_item_name);
        TextView fragment2_item_name_input = ll_f2.findViewById(R.id.fragment2_item_name_input);
        ImageView fragment2_item_image = ll_f2.findViewById(R.id.fragment2_item_image);
//        EditText Report_form_date_input = ll_f2.findViewById(R.id.Report_form_date_input);
//        EditText Report_form_time_input = ll_f2.findViewById(R.id.Report_form_time_input);
//        EditText Report_form_location_input = ll_f2.findViewById(R.id.Report_form_location_input);

        //Set the picture and text
        fragment2_item_date_input.setText(myinsurance_f2.getFragment2_item_date_input());
        fragment2_item_date.setText(myinsurance_f2.getFragment2_item_date());
        fragment2_item_name.setText(myinsurance_f2.getFragment2_item_name());
        fragment2_item_name_input.setText(myinsurance_f2.getFragment2_item_name_input());
        fragment2_item_image.setImageResource(myinsurance_f2.getFragment2_item_image());


        return ll_f2;
    }
}

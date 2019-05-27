package com.example.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.adapter_f3;


public class fragment3 extends Fragment {

    private ListView list;
    private com.example.myapplication.adapter_f3 adapter_f3 = null;
    private com.example.myapplication.fragment.notification_f3[] notification_f3;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3_notification, container, false);

        String fragment3_item_date_input = getResources().getString(R.string.fragment3_item_date_input);
        String fragment3_item_name_input = getResources().getString(R.string.fragment3_item_name_input);
        String fragment3_item_feedback_input = getResources().getString(R.string.fragment3_item_feedback_input);
        String fragment3_item_feedback = getResources().getString(R.string.fragment3_item_feedback);
//report 信息
        Bundle bundle=getArguments();
        final String[] location1=bundle.getStringArray(MainActivity.location1);
        final String[] time1=bundle.getStringArray(MainActivity.time1);
        final String[] feedback1=bundle.getStringArray(MainActivity.feedback1);
        final int[] status1=bundle.getIntArray(MainActivity.statusCode1);
        final int[] orderId1=bundle.getIntArray(MainActivity.orderId1);
        final int length1=bundle.getInt(MainActivity.length1);
        final String name1=bundle.getString(MainActivity.name1);
        final int phone1=bundle.getInt(MainActivity.phone1);
//        System.out.println(time1[0]);
//        System.out.println(feedback1[0]);
//////        i.putExtra(location1,location);
//////        i.putExtra(time1,time);
//        i.putExtra(orderId1,orderId);
//        i.putExtra(statusCode1,statusCode);
//        i.putExtra(feedback1,feedback);


        notification_f3 =new notification_f3[length1];
        for(int i=0;i<length1;i++){
            notification_f3[i]=new notification_f3(time1[i], name1, fragment3_item_feedback_input, R.drawable.fragment3_item_image, fragment3_item_feedback);
        }


        list = (ListView) view.findViewById(R.id.fragment3_list);

        adapter_f3 = new adapter_f3(getContext(),new Intent(getContext(),fragment3_detail.class ),notification_f3);

        list.setAdapter(adapter_f3);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                notification_f3 notification_f3 = adapter_f3.getItem(position);
                Intent i = adapter_f3.getIntent();

                i.putExtra("name","Name");
                i.putExtra("nameinput",name1);
                i.putExtra("date","Date:");
                i.putExtra("dateinput",time1[position]);
                i.putExtra("number","Number:");
                i.putExtra("numberinput",orderId1[position]);
                i.putExtra("phone","Phone:");
                i.putExtra("phoneinput",phone1);
                i.putExtra("location","Location:");
                i.putExtra("locationinput",location1[position]);
                i.putExtra("feedback","Feedback:");
                i.putExtra("feedbackinput","pass");
                i.putExtra("detail","Detail:");
                i.putExtra("detailinput",feedback1[position]);
                adapter_f3.startActivity();

            }
        });
        return view;
    }
}

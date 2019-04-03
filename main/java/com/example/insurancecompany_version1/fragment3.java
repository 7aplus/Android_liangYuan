package com.example.insurancecompany_version1;

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

public class fragment3 extends Fragment {

    private ListView list;
    private adapter_f3 adapter_f3 = null;
    private notification_f3[] notification_f3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3_notification, container, false);

        String fragment3_item_date_input = getResources().getString(R.string.fragment3_item_date_input);
        String fragment3_item_name_input = getResources().getString(R.string.fragment3_item_name_input);
        String fragment3_item_feedback_input = getResources().getString(R.string.fragment3_item_feedback_input);
        String fragment3_item_feedback = getResources().getString(R.string.fragment3_item_feedback);

        notification_f3 = new notification_f3[]{new notification_f3(fragment3_item_date_input, fragment3_item_name_input, fragment3_item_feedback_input, R.drawable.fragment3_item_image, fragment3_item_feedback)};

        list = (ListView) view.findViewById(R.id.fragment3_list);

        adapter_f3 = new adapter_f3(getContext(),new Intent(getContext(),fragment3_detail.class ),notification_f3);

        list.setAdapter(adapter_f3);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                notification_f3 notification_f3 = adapter_f3.getItem(position);
                Intent i = adapter_f3.getIntent();

                i.putExtra("name","Name:");
                i.putExtra("nameinput",notification_f3.getFragment3_item_name_input());
                i.putExtra("date","Date:");
                i.putExtra("dateinput",notification_f3.getFragment3_item_date_input());
                i.putExtra("number","Number:");
                i.putExtra("numberinput","55667788");
                i.putExtra("phone","Phone:");
                i.putExtra("phoneinput","13301248570");
                i.putExtra("type","Type:");
                i.putExtra("typeinput","1");
                i.putExtra("feedback","Feedback:");
                i.putExtra("feedbackinput",notification_f3.getFragment3_item_feedback_input());
                i.putExtra("detail","Detail:");
                i.putExtra("detailinput","Are you happy now???");
                adapter_f3.startActivity();

            }
        });
        return view;
    }
}

package com.example.insurancecompany_version1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fragment2 extends Fragment {

    private ListView list;
    private adapter_f2 adapter_f2 = null;
    private myinsurance_f2[] myinsurance_f2;




//    private int[] icon = new int[]{R.drawable.fragment2_item_image, R.drawable.fragment2_item_image};
//    private String[] date = new String[]{"date","date"};
//    private String[] date_input = new String[]{"2019.4.1","2019.3.28"};
//    private String[] name = new String[]{"name","name"};
//    private String[] name_input = new String[]{"Nick","Mary"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_myinsurance, container, false);
//        list = (ListView) view.findViewById(android.R.id.list);

        String fragment2_item_date = getResources().getString(R.string.fragment2_item_date);
        String fragment2_item_name = getResources().getString(R.string.fragment2_item_name);
        String fragment2_item_date_input = getResources().getString(R.string.fragment2_item_date_input);
        String fragment2_item_name_input = getResources().getString(R.string.fragment2_item_name_input);

        myinsurance_f2 = new myinsurance_f2[]{new myinsurance_f2(fragment2_item_date_input, fragment2_item_name_input, R.drawable.fragment2_item_image, fragment2_item_date, fragment2_item_name)};

        list = (ListView) view.findViewById(R.id.fragment2_list);

        adapter_f2 = new adapter_f2(getContext(),new Intent(getContext(),fragment2_report.class ),myinsurance_f2);

        list.setAdapter(adapter_f2);


//        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
//        for (int i = 0; i < date.length; i++) {
//            Map<String, Object> listItem = new HashMap<String, Object>();
//            listItem.put("1", icon[i]);
//            listItem.put("2", date[i]);
//            listItem.put("3", date_input[i]);
//            listItem.put("4", name[i]);
//            listItem.put("5", name_input[i]);
//            listItems.add(listItem);


//        return view;

//        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(),
//                listItems, R.layout.fragment2_listitem, new String[]{
//                "1", "2", "3", "4", "5"},
//                new int[]{R.id.fragment2_item_image, R.id.fragment2_item_date, R.id.fragment2_item_date_input, R.id.fragment2_item_name,
//                        R.id.fragment2_item_name_input});
//
//        list.setAdapter(simpleAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                myinsurance_f2 myinsurance_f2 = adapter_f2.getItem(position);
                Intent i = adapter_f2.getIntent();

                i.putExtra("name",myinsurance_f2.getFragment2_item_name());
                i.putExtra("nameinput",myinsurance_f2.getFragment2_item_name_input());
                i.putExtra("date",myinsurance_f2.getFragment2_item_date());
                i.putExtra("dateinput",myinsurance_f2.getFragment2_item_date_input());
                i.putExtra("number","Number:");
                i.putExtra("numberinput","55667788");
                i.putExtra("phone","Phone:");
                i.putExtra("phoneinput","13301248570");
                i.putExtra("type","Type:");
                i.putExtra("typeinput","1");
                i.putExtra("dateform","Date of loss");
                i.putExtra("timeform","Time of loss:");
                i.putExtra("locationform","Location:");
                i.putExtra("detailform","Detail Info:");
                adapter_f2.startActivity();

            }
        });
    return view;}
}

























    //listfragment fail
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        String[] listItem = {"a","b"};
//        int[] iconItem = { R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground};
//        adapter = new SimpleAdapter(getActivity(), getData(listItem, iconItem),
//                R.layout.fragment2_listitem, new String[] { "name", "icon" },
//                new int[] { R.id.fragment2_item_date_input, R.id.fragment2_item_image });

//    }
//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//    }
//    private List<? extends Map<String, ?>> getData(String[] strs, int[] icon) {
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//
//        for (int i = 0; i < 5; i++) {
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("name", strs[i]);
//            map.put("icon", icon[i]);
//            list.add(map);
//
//        }
//
//        return list;
//    }
//
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//    }
//
//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//
//    }
//}

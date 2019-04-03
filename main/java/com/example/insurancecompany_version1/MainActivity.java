package com.example.insurancecompany_version1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigation;
    private ListView fragment2_list;
    private ListView fragment3_list;


    fragment1 f1 = new fragment1();
    fragment2 f2 = new fragment2();
    fragment3 f3 = new fragment3();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameLayout, f1).commit();
                    return true;
                case R.id.navigation_dashboard:
                    getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameLayout, f2).commit();
                    return true;
                case R.id.navigation_notifications:
                    getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameLayout, f3).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment2_list = this.findViewById(R.id.fragment2_list);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        initListener();
    }
    private void initListener(){
        getSupportFragmentManager().beginTransaction().addToBackStack(null).add(R.id.frameLayout, f1).commit();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}

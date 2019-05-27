
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.myapplication.fragment.fragment1;
import com.example.myapplication.fragment.fragment2;
import com.example.myapplication.fragment.fragment3;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigation;
    private ListView fragment2_list;
    private ListView fragment3_list;
    public final static String name1="name1";
    public final static String phone1="phone1";
    public final static String email1="email1";
    public static final String location1="location1";
    public static final String time1="time1";
    public static final String statusCode1="status1";
    public static final String orderId1="orderId1";
    public static final String feedback1="feedback1";
    public static final String length1="length1";
    public static final String firstName1="firstName";
    public static final String lastName1="lastName";
    public static final String country1="country";
    public static final String password2="password";


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
//                    Toast.makeText(MainActivity.this,"hahah",Toast.LENGTH_LONG).show();
//                    Intent i = getIntent();
//                    String name2 = i.getStringExtra(start.use);
//                    final String username = name2;
//
////                check newcheck = new check();
//                    System.out.println("start check");
//
//                    Thread thread = new Thread(){
//                        @Override
//                        public void run(){
//                            getReport gr=new getReport(username);
//                            Intent i = new Intent(start.this,MainActivity.class);
//                            i.putExtra(use,userName);
//                            i.putExtra(phone1,phone);
//                            i.putExtra(email1,email);
//                            startActivity(i);
//                        }
//
//                    };
//
//                    thread.start();

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

        Intent i = getIntent();
        String name = i.getStringExtra(start.use);
        String phone = i.getStringExtra(start.phone1);
        String email = i.getStringExtra(start.email1);
        String password = i.getStringExtra(start.password2);
        String firstName=i.getStringExtra(start.firstName1);
        String lastName=i.getStringExtra(start.lastName1);
        String country=i.getStringExtra(start.country1);


        //report 信息
        String[] location=i.getStringArrayExtra(start.location1);
        String[] time=i.getStringArrayExtra(start.time1);
        int[] orderId=i.getIntArrayExtra(start.orderId1);
        int[] statusCode=i.getIntArrayExtra(start.statusCode1);
        String[] feedback=i.getStringArrayExtra(start.feedback1);
        int length=i.getIntExtra(start.length1,0);


        Bundle bundle = new Bundle();

        bundle.putString(name1,name);
        bundle.putString(phone1,phone);
        bundle.putString(email1,email);
        bundle.putString(password2,password);
        bundle.putString(firstName1,firstName);
        bundle.putString(lastName1,lastName);
        bundle.putString(country1,country);


        f1.setArguments(bundle);
        f2.setArguments(bundle);

        bundle.putStringArray(location1,location);
        bundle.putIntArray(statusCode1,statusCode);
        bundle.putIntArray(orderId1,orderId);
        bundle.putStringArray(feedback1,feedback);
        bundle.putStringArray(time1,time);
        bundle.putInt(length1,length);
        f3.setArguments(bundle);


    }
    private void initListener(){
        getSupportFragmentManager().beginTransaction().addToBackStack(null).add(R.id.frameLayout, f1).commit();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }


}

package com.example.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.transfer.check;
import com.example.myapplication.transfer.sendReport;
import com.example.myapplication.transfer.uploadUser;

public class fragment1 extends Fragment {
    @Nullable

    private TextView name;
    private EditText phone;
    private EditText email;
    private TextView nameAttribute;
    private TextView phoneAttribute;
    private TextView emailAttribute;
    private Button edit;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_myprofile, container, false);
        edit = view.findViewById(R.id.Edit_infor);
        name =  view.findViewById(R.id.Info_name_input);
        phone =  view.findViewById(R.id.Info_phone_input);
        email =  view.findViewById(R.id.Info_email_input);
        nameAttribute = view.findViewById(R.id.Info_name);
        phoneAttribute = view.findViewById(R.id.Info_phone);
        emailAttribute = view.findViewById(R.id.Info_email);

        Bundle bundle=getArguments();
        String name1=bundle.getString(MainActivity.name1);
        String phone1=bundle.getString(MainActivity.phone1);
        String email1=bundle.getString(MainActivity.email1);
        final String first1=bundle.getString(MainActivity.firstName1);
        final String last1=bundle.getString(MainActivity.lastName1);
        final String password1=bundle.getString(MainActivity.password2);
        final String country1=bundle.getString(MainActivity.country1);


        name.setText(name1);
        phone.setText(phone1);
        email.setText(email1);
        nameAttribute.setText(R.string.name);
        phoneAttribute.setText(R.string.phone);
        emailAttribute.setText(R.string.email);


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(){
                    final String name1 = (String)name.getText();
                    final String phone1 = phone.getText().toString();
                    final String email1 = email.getText().toString();
                    @Override
                    public void run(){
                        if(phone1.equals("")){
                            Looper.prepare();
                            AlertDialog.Builder builder  = new AlertDialog.Builder(getContext());
                            builder.setTitle(R.string.t ) ;
                            builder.setMessage(R.string.nophone ) ;
                            builder.setPositiveButton(R.string.yes,null );
                            builder.show();
                            Looper.loop();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else if(email1.equals("")){
                            Looper.prepare();
                            AlertDialog.Builder builder  = new AlertDialog.Builder(getContext());
                            builder.setTitle(R.string.t ) ;
                            builder.setMessage(R.string.noemail ) ;
                            builder.setPositiveButton(R.string.yes,null );
                            builder.show();
                            Looper.loop();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            uploadUser uu = new uploadUser(name1, phone1, email1,first1,last1,country1,password1);

                            Looper.prepare();
                            Toast.makeText(getContext(), R.string.submitss, Toast.LENGTH_SHORT).show();
                            Looper.loop();
                        }
                    }

                };

                thread.start();

            }
        });


        return view;
    }
}

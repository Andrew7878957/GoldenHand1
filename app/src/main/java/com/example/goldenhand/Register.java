package com.example.goldenhand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class Register extends AppCompatActivity {
    public Spinner spinner ;
    public android.widget.Switch Switch;
    public EditText multiline ,  phone ,address ;
    public TextView store ;
    public CheckBox online , physical ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        spinner =  findViewById(R.id.myspinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Register.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.egyptgov));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);


        Switch=findViewById(R.id.switch1);
        multiline=findViewById(R.id.multiline);
        phone=findViewById(R.id.phone);
        address=findViewById(R.id.address);
        store=findViewById(R.id.store);
        online=findViewById(R.id.onlinckbox);
        physical=findViewById(R.id.physicalckbox);


        Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    multiline.setVisibility(View.VISIBLE);
                    phone.setVisibility(View.VISIBLE);
                    address.setVisibility(View.VISIBLE);
                    store.setVisibility(View.VISIBLE);
                    online.setVisibility(View.VISIBLE);
                    physical.setVisibility(View.VISIBLE);
                    spinner.setVisibility(View.VISIBLE);




                }else {

                    multiline.setVisibility(View.INVISIBLE);
                    phone.setVisibility(View.INVISIBLE);
                    address.setVisibility(View.INVISIBLE);
                    store.setVisibility(View.INVISIBLE);
                    online.setVisibility(View.INVISIBLE);
                    physical.setVisibility(View.INVISIBLE);
                    spinner.setVisibility(View.INVISIBLE);

                }

            }
        });

    }
}

package com.example.goldenhand;

import android.app.ProgressDialog;
import android.content.Intent;
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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {


    public Spinner spinner ;
    public android.widget.Switch Switch;
    public EditText multiline ,  phone ,address ,fname , lname,password, confpass , email;
    public TextView store ;
    public CheckBox online , physical ;

    String str_email,str_password,str_fname,str_lname,str_conpasswordame,str_multiline
            ,str_address ,str_online,str_physical ,str_spinner,str_phone;
    String url = "http://androidapp.goldenhand.online/signup.php";


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
        fname = findViewById(R.id.firstnm);
        lname = findViewById(R.id.lastnm);
        password = findViewById(R.id.password);
        confpass = findViewById(R.id.conpassword);


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
    public void moveToLogin(View view) {

        startActivity(new Intent(getApplicationContext(),login_page.class));
        finish();
    }

    public void Register(View view) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait..");


        if(fname.getText().toString().equals("")){
            Toast.makeText(this, "Enter First name", Toast.LENGTH_SHORT).show();
        }
        else if(lname.getText().toString().equals("")){
            Toast.makeText(this, "Enter Last name", Toast.LENGTH_SHORT).show();
        }
        else if(password.getText().toString().equals("")){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        }
        else if(confpass.getText().toString().equals("")){
            Toast.makeText(this, "Enter confirm Password", Toast.LENGTH_SHORT).show();
        }
        else if(email.getText().toString().equals("")){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
        }
        else if(multiline.getText().toString().equals("")){
            Toast.makeText(this, "Enter lines about you ", Toast.LENGTH_SHORT).show();
        }

        else if(address.getText().toString().equals("")){
            Toast.makeText(this, "Enter Address", Toast.LENGTH_SHORT).show();
        }
      //  else if(spinner.getSelectedItem().toString().equals("")){
      //      Toast.makeText(this, "Enter Governorate", Toast.LENGTH_SHORT).show();
      //  }
        else if(phone.getText().toString().equals("")){
            Toast.makeText(this, "Enter Phone", Toast.LENGTH_SHORT).show();
        }else{

            progressDialog.show();
            str_fname = fname.getText().toString().trim();
            str_lname = lname.getText().toString().trim();
            str_email = email.getText().toString().trim();
            str_password = password.getText().toString().trim();
            str_conpasswordame = confpass.getText().toString().trim();
            str_multiline= multiline.getText().toString().trim();
            str_address=address.getText().toString().trim();
      //      str_spinner=spinner.getSelectedItem().toString().trim();
            str_phone=phone.getText().toString().trim();
            str_online=online.getText().toString().trim();
            str_physical=physical.getText().toString().trim();

            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    fname.setText("");
                    lname.setText("");
                    email.setText("");
                    password.setText("");
                    confpass.setText("");
                    multiline.setText("");
                    address.setText("");
                    phone.setText("");
                    online.setText("");
                    physical.setText("");
                   // spinner.getSelectedItem();

                    Toast.makeText(Register.this, response, Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();

                    params.put("first name",str_fname);
                    params.put("last name", str_lname);
                    params.put("email",str_email);
                    params.put("password",str_password);
                    params.put("multilines",str_multiline);
                    params.put("Address", str_address);
                    params.put("phone",str_phone);
                    params.put("online",str_online);
                    params.put("physical",str_physical);
                    params.put("governal", str_spinner);
                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(Register.this);
            requestQueue.add(request);


        }

    }
}

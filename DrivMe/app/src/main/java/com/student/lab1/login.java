package com.student.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by student on 5/24/2015.
 */
public class login extends FragmentActivity{
    //initializiing vari.
    EditText userName;
    EditText password;

        

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);

        userName= (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.password);
        Button login= (Button) findViewById(R.id.blogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextscreen = new Intent(getApplicationContext(), Drivmehomepage.class);
                startActivity(nextscreen);

                //sending data to ....



            }
        });


    }

}

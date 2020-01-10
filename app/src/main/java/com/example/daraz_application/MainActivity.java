package com.example.daraz_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button joinNowButton,loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        joinNowButton = findViewById(R.id.main_join_now_btn);
        loginButton = findViewById(R.id.main_login_btn);

        // Initializing paper for this activity

        Paper.init(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);

            }
        });

        joinNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });

        String UserPhoneKey = Paper.book().read(Prevalent.UserPhoneKey);
        String UserPasswordKey = Paper.book().read(Prevalent.UserPasswordKey);

        // This part only executes if the user checks the checkbox so we check return type is not null first

        if (UserPhoneKey != "" && UserPasswordKey != "")
        {
            if(!TextUtils.isEmpty(UserPhoneKey) && !TextUtils.isEmpty(UserPasswordKey))
            {
                AllowAccess(UserPhoneKey, UserPasswordKey);
            }

        }


    }

    private void AllowAccess(final String phone, final String password)
    {


        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();



        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {

                if(dataSnapshot.child("Users").child(phone).exists())
                {


                    Users usersData = dataSnapshot.child("Users").child(phone).getValue(Users.class);



                    if(usersData.getPhone().equals(phone))
                    {
                        if(usersData.getPassword().equals(password))
                        {
                            Toast.makeText(MainActivity.this, "Already logged in", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this,HomeActivity.class);
                            startActivity(i);


                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                else
                {
                    Toast.makeText(MainActivity.this, "Account with this " + phone + " number do not exist", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Sending back to register page", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this,RegisterActivity.class);
                    startActivity(i);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}



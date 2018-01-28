package com.example.emora.followme;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileScreen extends AppCompatActivity {

    private EditText etName;
    private EditText etNumber;
    //private EditText etAddress;
    private EditText etRace;
    private EditText etHairColor;
    private EditText etEyeColor;
    private EditText etHeight;
    private EditText etWeight;
    private EditText etAddtnInfo;
    private Button updateProfileButton;
    private Button homeScreenButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        etName = (EditText) findViewById(R.id.userName);
        etNumber = (EditText) findViewById(R.id.userNumber);
        etRace = (EditText) findViewById(R.id.userRace);
        etHairColor = (EditText) findViewById(R.id.userHairColor);
        etEyeColor = (EditText) findViewById(R.id.userEyeColor);
        etHeight = (EditText) findViewById(R.id.userHeight);
        etWeight = (EditText) findViewById(R.id.userWeight);
        etAddtnInfo = (EditText) findViewById(R.id.userInfo);
        updateProfileButton = (Button) findViewById(R.id.updateProfile);
        homeScreenButton = (Button) findViewById(R.id.mainPageButton);


        updateProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (confirmationAttempt()) {
                    User user = new User(etName.getText().toString(), etNumber.getText().toString(),
                            etHeight.getText().toString(),etWeight.getText().toString(),
                            etEyeColor.getText().toString(), etHairColor.getText().toString(),
                            etRace.getText().toString(), etAddtnInfo.getText().toString());
                } else {
                    Toast.makeText(ProfileScreen.this, "Missing Fields", Toast.LENGTH_LONG).show();

                }

            }

        });

        homeScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileScreen.this, MainActivity.class));
            }
        });


    }

    private boolean confirmationAttempt(){

        return etName.getText().toString() != null && etNumber.getText().toString() != null
                && etRace.getText().toString() != null && etHairColor.getText().toString() != null
                && etHairColor.getText().toString() != null && etEyeColor.getText().toString() != null
                && etHeight.getText().toString() != null && etWeight.getText().toString() != null
                && etAddtnInfo.getText().toString() != null;
    }





}

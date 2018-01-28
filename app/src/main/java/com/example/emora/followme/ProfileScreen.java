package com.example.emora.followme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ProfileScreen extends AppCompatActivity {

    private EditText etName;
    private EditText etNumber;
    //private EditText etAddress;
    private EditText etRace;
    private EditText etAge;
    private EditText etHairColor;
    private EditText etEyeColor;
    private EditText etHeight;
    private EditText etWeight;
//    private EditText etAddtnInfo;
    private Button updateProfileButton;
    private Button homeScreenButton;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String DEFAULT_STRING = "";
    //TODO: Make Additional Info a List of Items     <---- Removed Additional Info. Not using User object.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Store Profile elements in a publicly accessible dictionary
        //To Display
            // - Extract Values from dictionary as a list of items
            // - Populate the list view with these values
        sharedPreferences = getSharedPreferences("UserProfiletData", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        etName = findViewById(R.id.userName);
        etNumber = findViewById(R.id.userNumber);
        etAge = findViewById(R.id.userAge);
        etRace = findViewById(R.id.userRace);
        etHairColor = findViewById(R.id.userHairColor);
        etEyeColor = findViewById(R.id.userEyeColor);
        etHeight = findViewById(R.id.userHeight);
        etWeight = findViewById(R.id.userWeight);
//        etAddtnInfo = findViewById(R.id.userInfo);
        updateProfileButton = findViewById(R.id.updateProfile);
        homeScreenButton = findViewById(R.id.mainPageButton);


        // Save All Profile Information In The Device's Key-Value Store
        updateProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (confirmationAttempt()) {
                    editor.putString("name", etName.getText().toString());
                    editor.putString("number", etNumber.getText().toString());
                    editor.putString("age", etAge.getText().toString());
                    editor.putString("race", etRace.getText().toString());
                    editor.putString("hairColor", etHairColor.getText().toString());
                    editor.putString("eyeColor", etEyeColor.getText().toString());
                    editor.putString("height", etHeight.getText().toString());
                    editor.putString("weight", etWeight.getText().toString());
                    Toast.makeText(ProfileScreen.this, "Data Successfully Saved", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(ProfileScreen.this, "No Updates Found", Toast.LENGTH_LONG).show();

                }
                //Update Profile With Data from SharedPreferences
                etName.setText(sharedPreferences.getString("name", "Name"));
                etNumber.setText(sharedPreferences.getString("number", "000-000-0000"));
                etRace.setText(sharedPreferences.getString("race", "Race"));
                etHairColor.setText(sharedPreferences.getString("hairColor", "Hair Color"));
                etEyeColor.setText(sharedPreferences.getString("eyeColor", "Eye Color"));
                etHeight.setText(sharedPreferences.getString("height", "Height"));
                etWeight.setText(sharedPreferences.getString("weight", "Weight"));

            }

        });

        //Update Profile With Data from SharedPreferences
        etName.setText(sharedPreferences.getString("name", DEFAULT_STRING));
        etNumber.setText(sharedPreferences.getString("number", DEFAULT_STRING));
        etRace.setText(sharedPreferences.getString("race", DEFAULT_STRING));
        etHairColor.setText(sharedPreferences.getString("hairColor", DEFAULT_STRING));
        etEyeColor.setText(sharedPreferences.getString("eyeColor", DEFAULT_STRING));
        etHeight.setText(sharedPreferences.getString("height", DEFAULT_STRING));
        etWeight.setText(sharedPreferences.getString("weight", DEFAULT_STRING));



        homeScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileScreen.this, MainActivity.class));
            }
        });


    }

    //Save Data To SharedPreferences
    public void saveData() {
        if (confirmationAttempt()) {
            editor.putString("name", etName.getText().toString());
            editor.putString("number", etNumber.getText().toString());
            editor.putString("race", etRace.getText().toString());
            editor.putString("hairColor", etHairColor.getText().toString());
            editor.putString("eyeColor", etEyeColor.getText().toString());
            editor.putString("height", etHeight.getText().toString());
            editor.putString("weight", etWeight.getText().toString());
            Toast.makeText(ProfileScreen.this, "Data Successfully Saved", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(ProfileScreen.this, "No Updates Found", Toast.LENGTH_LONG).show();

        }
    }


    public void loadData(){
        etName.setText(sharedPreferences.getString("name", DEFAULT_STRING));
        etNumber.setText(sharedPreferences.getString("number", DEFAULT_STRING));
        etRace.setText(sharedPreferences.getString("race", DEFAULT_STRING));
        etHairColor.setText(sharedPreferences.getString("hairColor", DEFAULT_STRING));
        etEyeColor.setText(sharedPreferences.getString("eyeColor", DEFAULT_STRING));
        etHeight.setText(sharedPreferences.getString("height", DEFAULT_STRING));
        etWeight.setText(sharedPreferences.getString("weight", DEFAULT_STRING));
    }
    private boolean confirmationAttempt(){

        return etName.getText().toString() != null || etNumber.getText().toString() != null
                || etRace.getText().toString() != null || etHairColor.getText().toString() != null
                || etHairColor.getText().toString() != null || etEyeColor.getText().toString() != null
                || etHeight.getText().toString() != null || etWeight.getText().toString() != null;
    }





}

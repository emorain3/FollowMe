package com.example.emora.followme;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class NewWatcherScreen extends AppCompatActivity {

    private EditText etWatcherName;
    private EditText etWatcherNumber;
    private CheckBox chRestrictNewWatcher;
    private Button btnNewWatcherToWatchlist;
    private CheckBox chSendNewWatcherRequest;
    private Button btnConfirmNewWatcher;
    private User currentUser;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_watcher_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etWatcherName = (EditText) findViewById(R.id.watcherName);
        etWatcherNumber = (EditText) findViewById(R.id.watcherNumber);
        btnNewWatcherToWatchlist = (Button) findViewById(R.id.newWatcherToWatchList);
        chRestrictNewWatcher = (CheckBox) findViewById(R.id.restrictNewWatcher);
        chSendNewWatcherRequest = (CheckBox) findViewById(R.id.sendNewWatcherRequest);
        btnConfirmNewWatcher = (Button) findViewById(R.id.confirmNewWatcher);


        if(ContextCompat.checkSelfPermission(NewWatcherScreen.this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(NewWatcherScreen.this,
                    Manifest.permission.SEND_SMS)) {
                ActivityCompat.requestPermissions(NewWatcherScreen.this,
                        new String[] {Manifest.permission.SEND_SMS}, 1);
            }else {
                ActivityCompat.requestPermissions(NewWatcherScreen.this,
                        new String[]{Manifest.permission.SEND_SMS}, 1);
            }
        } else {
        }

        btnConfirmNewWatcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("+19124329083", null, "Code is XXYX", null, null);
                    Toast.makeText(NewWatcherScreen.this, "Ayyyye!", Toast.LENGTH_SHORT).show();
                }catch (Exception e) {
                    Toast.makeText(NewWatcherScreen.this, "You fucked up!", Toast.LENGTH_LONG).show();
                }
//                if (confirmationAttempt()) {

//                    Watcher watcher = new Watcher(etWatcherName.getText().toString(),
//                            etWatcherNumber.getText().toString(), chRestrictNewWatcher.isChecked(),
//                            chSendNewWatcherRequest.isChecked());


//                    sendSMSMessage("+14706293412", "testing roger wilson");
//
////                } else {
//                    Toast.makeText(NewWatcherScreen.this, "You fucked up!", Toast.LENGTH_LONG).show();
////                }
            }
        });

        btnNewWatcherToWatchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewWatcherScreen.this, WatchlistScreen.class));
            }
        });


    }

    private boolean confirmationAttempt() {
        return etWatcherName.getText().toString() != null &&
                etWatcherNumber.getText().toString() != null;

    }


    public void sendSMSMessage(String watcherNum, String watcherCode) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) !=
                PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            }else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        0);
            }
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(NewWatcherScreen.this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED ){
                        Toast.makeText(this, "Code XXXX delivered", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(getApplicationContext(),
                            "SMS failed, please try again.", Toast.LENGTH_SHORT).show();{
                    }
                    return;
                }
            }
        }

    }

}

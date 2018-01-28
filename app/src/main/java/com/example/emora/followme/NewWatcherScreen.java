package com.example.emora.followme;

import android.Manifest;
import android.app.PendingIntent;
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

        btnConfirmNewWatcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (confirmationAttempt()) {

                    Watcher watcher = new Watcher(etWatcherName.getText().toString(),
                            etWatcherNumber.getText().toString(), chRestrictNewWatcher.isChecked(),
                            chSendNewWatcherRequest.isChecked());
                    sendText("+919124329083", "testing roger wilson");

                } else {
                    Toast.makeText(NewWatcherScreen.this, "You fucked up!", Toast.LENGTH_LONG).show();
                }
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
    public void sendText(String watcherNum, String watcherCode) {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.SEND_SMS},1);
        ArrayList<String> messages = new ArrayList<>();
        messages.add(watcherCode);
        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS);

        if(permissionCheck == PackageManager.PERMISSION_GRANTED) {
        SmsManager smsManager = SmsManager.getDefault();
        if (watcherNum != null) {
            smsManager.sendMultipartTextMessage(watcherNum,
                    null, messages, null, null);
        }
    }
}


    }

package com.example.emora.followme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

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
                            chSendNewWatcherRequest.isChecked(),null);
                }
            }
        });


    }

    private boolean confirmationAttempt() {
        return etWatcherName.getText().toString() != null &&
                etWatcherNumber.getText().toString() != null;

    }

}

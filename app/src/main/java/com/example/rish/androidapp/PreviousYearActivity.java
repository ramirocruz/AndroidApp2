package com.example.rish.androidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PreviousYearActivity extends AppCompatActivity implements View.OnClickListener{
   Button buttonwebview,buttonlistdownloads,buttondownload,buttonupload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_year);
        buttondownload= (Button) findViewById(R.id.buttonDownload);
        buttonlistdownloads= (Button) findViewById(R.id.buttondownloadedpapers);
        buttonupload= (Button) findViewById(R.id.buttonSubmit);
        buttonwebview=(Button)findViewById(R.id.buttonquestionpapersonline);
        buttonwebview.setOnClickListener(this);
        buttonlistdownloads.setOnClickListener(this);
        buttonupload.setOnClickListener(this);
        buttondownload.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonquestionpapersonline:
                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                break;
            case R.id.buttondownloadedpapers:
                startActivity(new Intent(getApplicationContext(),DownloadListView.class));
                break;
            case R.id.buttonDownload:
                startActivity(new Intent(getApplicationContext(),IntermediateActivity.class).putExtra("mode_download",true));
                break;
            case R.id.buttonSubmit:
                startActivity(new Intent(getApplicationContext(),IntermediateActivity.class).putExtra("mode_download",false));
        }

    }
}

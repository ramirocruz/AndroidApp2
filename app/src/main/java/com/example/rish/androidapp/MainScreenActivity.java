package com.example.rish.androidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreenActivity extends AppCompatActivity {
    Button buttonwebview,buttonlistdownloads,buttondownload,buttonsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        buttondownload=(Button)findViewById(R.id.buttondownload);
        buttonlistdownloads=(Button)findViewById(R.id.buttondownloads);
        buttonwebview=(Button)findViewById(R.id.buttonwebview);
        buttonsubmit=(Button)findViewById(R.id.buttonsubmit);
        buttonsubmit.setOnClickListener(clickobject);
        buttondownload.setOnClickListener(clickobject);
        buttonlistdownloads.setOnClickListener(clickobject);
        buttonwebview.setOnClickListener(clickobject);
    }

    private View.OnClickListener clickobject=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
      switch(v.getId()){

          case R.id.buttonwebview:
              startActivity(new Intent(getApplicationContext(),ProfileActivity.class));

              break;
          case R.id.buttondownload:
              startActivity(new Intent(getApplicationContext(),IntermediateActivity.class).putExtra("mode_download",true));

              break;
          case R.id.buttondownloads:
              startActivity(new Intent(getApplicationContext(),DownloadListView.class));
              break;
          case R.id.buttonsubmit:
              startActivity(new Intent(getApplicationContext(),IntermediateActivity.class).putExtra("mode_download",false));



      }
        }
    };
}

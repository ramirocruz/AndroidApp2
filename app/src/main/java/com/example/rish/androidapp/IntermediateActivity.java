package com.example.rish.androidapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class IntermediateActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    private final static int GOOGLE_REQUEST_CODE=121;
    boolean mode_download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean mode_download=getIntent().getBooleanExtra("mode_download",true);
       // setContentView(R.layout.activity_splash_screen);
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            if(mode_download)
            startActivity(new Intent(getApplicationContext(),StorageHelperActivity.class).putExtra("Status",false));
            else
            startActivity(new Intent(getApplicationContext(),StorageHelperActivity.class).putExtra("Status",true));
            finish();
        }else{
            startActivityForResult(new Intent(getApplicationContext(),MainActivity.class),GOOGLE_REQUEST_CODE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==GOOGLE_REQUEST_CODE){
            if(mode_download)
                startActivity(new Intent(getApplicationContext(),StorageHelperActivity.class).putExtra("Status",false));
            else
                startActivity(new Intent(getApplicationContext(),StorageHelperActivity.class).putExtra("Status",true));
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),MainScreenActivity.class));
            finish();
        }
    }
}

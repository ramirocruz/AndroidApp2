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

    final boolean mode_download[]=new boolean[1];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          mode_download[0]=getIntent().getBooleanExtra("mode_download",true);

        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            if(mode_download[0]){
                startActivity(new Intent(getApplicationContext(),NewActivity.class).putExtra("Status",false));
                finish();}
            else{
                startActivity(new Intent(getApplicationContext(),StorageHelperActivity.class).putExtra("Status",true));
                finish();}
        }else{
            startActivityForResult(new Intent(getApplicationContext(),MainActivity.class),GOOGLE_REQUEST_CODE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==GOOGLE_REQUEST_CODE ){
            if(resultCode==GOOGLE_REQUEST_CODE){
            if(mode_download[0]){
                startActivity(new Intent(getApplicationContext(),NewActivity.class).putExtra("Status",false));
                finish();}
            else{
                startActivity(new Intent(getApplicationContext(),StorageHelperActivity.class).putExtra("Status",true));
                finish();}}
            else{
                startActivity(new Intent(getApplicationContext(),PreviousYearActivity.class));
                finish();
            }
        }
        else{
            Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),PreviousYearActivity.class));
            finish();
        }
    }
}

package com.example.rish.androidapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Plus;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    private static final int REQUEST_CODE_SIGNIN_DOWNLOAD=88;
    private static final int REQUEST_CODE_SIGNIN_UPLOAD=89;


    private SignInButton signInButton;
    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions googleSignInOptions;
    private boolean mode_download;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton= (SignInButton) findViewById(R.id.signInButton);
        googleSignInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestProfile().build();
        googleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,googleSignInOptions)
                .addApi(Plus.API).build();
        signInButton.setScopes(googleSignInOptions.getScopeArray());
        signInButton.setOnClickListener(clickobj);
    }

    private View.OnClickListener clickobj=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent signin=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
            mode_download=getIntent().getBooleanExtra("mode_download",true);
            if(mode_download)
            startActivityForResult(signin,REQUEST_CODE_SIGNIN_DOWNLOAD);
            else
            startActivityForResult(signin,REQUEST_CODE_SIGNIN_UPLOAD);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_SIGNIN_DOWNLOAD){
            startActivity(new Intent(getApplicationContext(),StorageHelperActivity.class).putExtra("Status",false).putExtra("Name","1"));
            finish();
        }
        else if(requestCode==REQUEST_CODE_SIGNIN_UPLOAD){
            startActivity(new Intent(getApplicationContext(),StorageHelperActivity.class).putExtra("Status",true).putExtra("Name","1"));
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(),"Error.. Something went wrong..",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}

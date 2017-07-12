package com.example.rish.androidapp;

import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private static final int REQUEST_CODE_SIGNIN=88;       //Constant to check the intent result to google signin


    //Firebase authentication variables
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;
//End of Firebase authentication variables

    private SignInButton signInButton;
    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions googleSignInOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        signInButton= (SignInButton) findViewById(R.id.signInButton);
        googleSignInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail()
        .requestIdToken(getString(R.string.default_web_client_id))
        .build();
        googleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,googleSignInOptions)
                .addApi(Plus.API).build();

        //Firebase initialization
        firebaseAuth=FirebaseAuth.getInstance();




        signInButton.setScopes(googleSignInOptions.getScopeArray());
        signInButton.setOnClickListener(clickobj);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        updateUI(firebaseUser);
    }

    private View.OnClickListener clickobj=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          googlesignin();  // made sign in function
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_SIGNIN){

            GoogleSignInResult googleSignInResult=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if(googleSignInResult.isSuccess()){
                //Google sign in was successfull so we can now authenticate with the firebase
                GoogleSignInAccount googleSignInAccount=googleSignInResult.getSignInAccount();
                firebaseAuthwithGoogle(googleSignInAccount); //call to a user made function for further procedure
            }
            else{
                //Failed to sign in
                updateUI(null);
            }

        }
        else {
            //Intent failure of some sort
        }

            }




            private void firebaseAuthwithGoogle(GoogleSignInAccount googleSignInAccount){


                AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
                firebaseAuth.signInWithCredential(authCredential)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    FirebaseUser user = firebaseAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(getApplicationContext(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }

                            }
                        });
            }


    private void googlesignin(){
        Intent signin=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(signin,REQUEST_CODE_SIGNIN);
    }


    private void googlesignout(){

       firebaseAuth.signOut();//firebase signout

        //Google sign out
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                updateUI(null);
            }
        });


    }
    private void googlerevokeaccess(){

        firebaseAuth.signOut();
        //Google revoke access
        Auth.GoogleSignInApi.revokeAccess(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                updateUI(null);
            }
        });
    }



     private void updateUI(FirebaseUser firebaseUser){

         if(firebaseUser!=null){
             //This means user is signed in

                 startActivity(new Intent(getApplicationContext(),IntermediateActivity.class).putExtra("LoginStatus",true));
                 finish();
         }else
         {//User is signed out
             Toast.makeText(getApplicationContext(),"Cannot Sign in",Toast.LENGTH_SHORT).show();

            }}

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
         Toast.makeText(getApplicationContext(),"Google Services Error.",Toast.LENGTH_SHORT).show();
    }
}

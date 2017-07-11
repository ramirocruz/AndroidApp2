package com.example.rish.androidapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    ListView listview;
    PDFAdapterWeb arraypdf;
    //
    TextView textView;
    ProgressDialog progressDialog;
    Button btnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        btnlogout=(Button)findViewById(R.id.logout);
        btnlogout.setOnClickListener(click);
        textView=(TextView)findViewById(R.id.showemail);
        textView.setText("Pdf list");

        listview=(ListView)findViewById(R.id.theListView);
        arraypdf=new PDFAdapterWeb(this,listitemnames);
        list();

    }
    private void list() {


        listview.setAdapter(arraypdf);
        listview.setOnItemClickListener(itemclick);
    }
    private AdapterView.OnItemClickListener itemclick=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Toast.makeText(ProfileActivity.this,position+"  "+id+" "+listitemurl[position],Toast.LENGTH_SHORT).show();
            Intent urlintent=new Intent(NewActivity.this,StorageHelperActivity.class);
            urlintent.putExtra("Name",listitemnames[position]);
            urlintent.putExtra("Status",false);
            try{startActivity(urlintent);}catch (Exception e){
                Toast.makeText(NewActivity.this,"Here" + e.toString(),Toast.LENGTH_LONG).show();
            }
        }
    };

    private View.OnClickListener click=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(NewActivity.this,"Button Pressed",Toast.LENGTH_SHORT).show();
//            progressDialog.setMessage("Signing out...");
//            progressDialog.show();                                              // show the loading sign
//           // firebaseAuth.signOut();        //Sign out the firebase
//            finish();                     //End the current activity
//            startActivity(new Intent(ProfileActivity.this,LoginActivity.class));           //Start the activity LoginActivity     go to login page
        }
    };

    private final String[] listitemnames={
            "crmo-2013-solutions-1",
            "crmo-2013-solutions-2",
            "crmo-2013-solutions-2 (2)",
            "crmo-2013-solutions-4",
            "crmosol-12-1",
            "crmosol-12-2",
            "crmosol-12-3",
            "crmosol-12-4",
            "solutions-to-rmo-2013-mumbai-region",
            "solutions-to-rmo-2013-mumbai-region (2)",
            "inmo-2000",
            "inmo-2001",
            "inmo-2002",
            "inmo-2003",
            "inmo-2004",
            "inmo-2005",
            "inmo-2006",
            "inmo-2007",
            "inmo-2008",
            "inmo-2009",
            "inmo-2010",
            "inmo-2011",
            "inmo-2012",
            "inmo-2013",
            "rmo-2000",
            "rmo-2001",
            "rmo-2002",
            "rmo-2003",
            "rmo-2004",
            "rmo-2005",
            "rmo-2006",
            "rmo-2007",
            "rmo-2008",
            "rmo-2009",
            "rmo-2010",
            "rmo-2011",
            "rmo-2012-mumbai-region",
            "rmo-2013-mumbai-region",
    };








    private final String[] listitemurl={
            "https://drive.google.com/open?id=0B5sOqfMxLg8uU3ZvdjVfQWtWeW8",
            "https://drive.google.com/open?id=0B5sOqfMxLg8uNHpZWXotYzBoRjQ",
            "https://drive.google.com/open?id=0B5sOqfMxLg8uNUkxMTZfazBTZHc",
            "https://drive.google.com/open?id=0B5sOqfMxLg8uZzlYWTN1TldMOWM",
            "https://drive.google.com/open?id=0B5sOqfMxLg8uUV8zQllaR0JfbTQ",
            "https://drive.google.com/open?id=0B5sOqfMxLg8uVVJJc1ZZZVM2cXM",
            "https://drive.google.com/open?id=0B5sOqfMxLg8uS2VsbENLSVgwTVE",
            "https://drive.google.com/open?id=0B5sOqfMxLg8uTTNCOG8zSS0xWms",
            "https://drive.google.com/open?id=0B5sOqfMxLg8uN09VYlpNN2xmT1k",
            "https://drive.google.com/open?id=0B5sOqfMxLg8uVXhWQ09sV2RaODA",
            "https://drive.google.com/open?id=0B5sOqfMxLg8ubXVPejh1VHl3YkE",
            "https://drive.google.com/open?id=0B5sOqfMxLg8uNGU3QVlTWTRObHc",
            "https://drive.google.com/open?id=0B5sOqfMxLg8uME1HN2l0Vl9qMm8",
            "https://drive.google.com/open?id=0B5sOqfMxLg8ud1dKOFVFdVowUXM",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uSG5BSUVoN1JrTjQ",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uc1BaRkNPU0x4d0k",
        "https://drive.google.com/open?id=0B5sOqfMxLg8ub2h1SEkzbHVBdkk",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uVnFHMFVxeHlGazQ",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uRGJHeEpvVm9fVlk",
        "https://drive.google.com/open?id=0B5sOqfMxLg8ucHB4S0NWLVVwNkU",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uTk5sMGxtMlQwdUU",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uSVJHNnl3ckduWDA",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uazI3dFU5Y3BIbHc",
        "https://drive.google.com/open?id=0B5sOqfMxLg8ueUpBV0pjOEZTc2M",
        "https://drive.google.com/open?id=0B5sOqfMxLg8ubGR6dlJkQ3VPRFE",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uWjZqc04wZW5CQ2s",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uWS05bzkxald3b3M",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uS1RJdzgwZldTeDQ",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uYVRVZzlqaDFNN00",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uVkVqQ0trdGtFU2s",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uSVRFc1lXb3B6emc",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uSVlaZ0IwTm52VWM",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uNFdTU0RacWFiRG8",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uVjNKN29jMUtiSlU",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uLXlGLTVlZ3lrNlk",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uZGxWMGgySFNVNDQ",
        "https://drive.google.com/open?id=0B5sOqfMxLg8udm1qUklNRGVaaUU",
        "https://drive.google.com/open?id=0B5sOqfMxLg8uakk1ckI1LXpBNnc",
};
}







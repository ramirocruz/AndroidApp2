package com.example.rish.androidapp;


import android.content.Intent;

import android.net.Uri;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;




public class PdfViewerActivity extends AppCompatActivity {
    //PDFView pdfView;

Button buttondownload,buttonupload,buttonlistdownload;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

          buttondownload=(Button)findViewById(R.id.btndownload);
        buttonupload=(Button)findViewById(R.id.btnupload);
        buttonlistdownload=(Button)findViewById(R.id.downloadlist);
        buttonupload.setOnClickListener(click);
        buttondownload.setOnClickListener(click);
        buttonlistdownload.setOnClickListener(click);


    }
private View.OnClickListener click =new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btndownload){
            startActivity(new Intent(getApplicationContext(),StorageHelperActivity.class).putExtra("Name","1").putExtra("Status",false));
        }
        else
            if(v.getId()==R.id.btnupload){
            startActivity(new Intent(getApplicationContext(),StorageHelperActivity.class).putExtra("Name","1").putExtra("Status",true));
        }else
            {
                startActivity(new Intent(getApplicationContext(),DownloadListView.class));
            }

    }
};





}

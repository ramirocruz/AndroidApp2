package com.example.rish.androidapp;


import android.content.Intent;

import android.net.Uri;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

import java.io.File;


public class PdfViewerActivity extends AppCompatActivity {
    PDFView pdfView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);
         pdfView=(PDFView)findViewById(R.id.pdfview);
        pdfView.setVerticalScrollBarEnabled(true);
        pdfView.setHorizontalScrollBarEnabled(false);
        String path=getIntent().getStringExtra("Path");

        File file=new File(path);
        if(file.canRead())
        {
            //LOAD IT
            pdfView.fromFile(file).defaultPage(1).onLoad(new OnLoadCompleteListener() {
                @Override
                public void loadComplete(int nbPages) {
                    Toast.makeText(getApplicationContext(), String.valueOf(nbPages), Toast.LENGTH_SHORT).show();
                }
            }).load();
        }
    }


    }







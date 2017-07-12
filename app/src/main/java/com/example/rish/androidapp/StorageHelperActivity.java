package com.example.rish.androidapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.net.Uri;

import android.support.annotation.NonNull;

import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.text.SimpleDateFormat;


public class StorageHelperActivity extends AppCompatActivity {
    static final int UploadFromSelectApp = 9501;
    static final int UploadFromFilemanager = 9502;

    final String pathtofirebase = "gs://androidapp-6745a.appspot.com/MathsOlympiad/";
    final String pathtofirebaseupload = "gs://androidapp-6745a.appspot.com/MathsOlympiadUpload/";
    private static String downloaddirpath = "/storage/emulated/0/Olympy/";
    private  String name;
    private boolean status;
    private String extention = ".pdf";
    public static File dir = new File(downloaddirpath);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_helper);
        name=getIntent().getStringExtra("Name");
        status=getIntent().getBooleanExtra("Status",false);
        String path=pathtofirebase+name+extention;
      if(isNetworkAvaliable(getApplicationContext())) {
            if (!status) {

                DownloadFromFirebaseFromPath(downloaddirpath, path);


            } else


            {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

                UploadToFirebaseFromSelectedApp("Testing");


            }
        }

        else{
            Toast.makeText(getApplicationContext(),"Error No internet connection",Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    private void DownloadFromFirebaseFromPath(final String downloadPathTo,final String downloadPathFrom) {



                dir.mkdirs();
                final String DownloadPathTo = downloadPathTo;
                final String DownloadPathFrom = downloadPathFrom;
                final StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(DownloadPathFrom);


                Toast.makeText(getApplicationContext(), "Download file ...", Toast.LENGTH_SHORT).show();

                File file = new File(DownloadPathTo + name + DownloadPathFrom.substring(DownloadPathFrom.lastIndexOf('.')));
                final int flag[] = new int[1];
                flag[0] = 1;
                if (file.exists()) {
                    final File tempfile = file;
                    storageReference.getMetadata().addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
                        @Override
                        public void onSuccess(StorageMetadata storageMetadata) {
                            if (storageMetadata.getSizeBytes() == tempfile.getTotalSpace()) {
                                Toast.makeText(getApplicationContext(), "File already exists", Toast.LENGTH_SHORT).show();
                            } else
                                flag[0] = 0;
                        }
                    });
                    if (flag[0] == 0)
                        file.delete();
                }
                try {
                    storageReference.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(getApplicationContext(), "Download completed", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Download Failure : " + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });


                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Download Failed : " + e.toString(), Toast.LENGTH_SHORT).show();
                }

    }

    private void UploadToFirebaseFromSelectedApp (String uploadName)
    {
        String UploadName = uploadName;
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
       // Toast.makeText(getApplicationContext(),"Please select from apps provided",Toast.LENGTH_LONG).show();
       try{ startActivityForResult(Intent.createChooser(intent, "Upload from ..."), UploadFromSelectApp);}catch(Exception e){
           Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
       }
    }
//
//    private void UploadToFirebaseFromFilemanager (String uploadName)
//    {
//        String UploadName = uploadName;
//        Intent intent = new Intent("com.sec.android.app.myfiles.PICK_DATA");
//        intent.putExtra("CONTENT_TYPE", "*/*");
//        intent.addCategory(Intent.CATEGORY_DEFAULT);
//        startActivityForResult(intent, UploadFromFilemanager);
//    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
//        if (requestCode == UploadFromFilemanager)
//        {
//            final Uri currFileURI = intent.getData();
//             Toast.makeText(getApplicationContext(),currFileURI.toString()+"  "+currFileURI.getLastPathSegment().toString(),Toast.LENGTH_LONG).show();
//            try{
//                Toast.makeText(getApplicationContext(), "Upload file ...", Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(),currFileURI.toString()+"  "+currFileURI.getLastPathSegment().toString(),Toast.LENGTH_LONG).show();
//                String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//                StorageReference storageReference = FirebaseStorage.getInstance().getReference(pathtofirebaseupload+currFileURI.getLastPathSegment());
//                storageReference.putFile(currFileURI).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        Toast.makeText(getApplicationContext(), "File successfully uploaded..", Toast.LENGTH_SHORT).show();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(getApplicationContext(), "Uploading Failed..", Toast.LENGTH_SHORT).show();
//                    }
//                });}catch(Exception e){
//                Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
//            }
//        }

        if (requestCode == UploadFromSelectApp)
        {
            Toast.makeText(getApplicationContext(), "Upload file  selected app...", Toast.LENGTH_SHORT).show();
            final Uri uri = intent.getData();
            //Generating a unique name:
            String name = uri.getLastPathSegment();//Getting the file name
            String onlyname="",extension="";
try{             onlyname = name.substring(0, name.lastIndexOf("."));          //Getting the file name without extension
             extension = name.substring(name.lastIndexOf("."));                //Getting the rest of the file name
              }catch (Exception e){}

            java.util.Date date = new java.util.Date();
            String timestamp = "";
            timestamp = new SimpleDateFormat("_yyyyMMddHHmmss").format(date); //Getting the current timestamp
            //Concatenating all the strings to a single entity
            String finalname = onlyname + timestamp + extension;

            try {
                StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(pathtofirebaseupload + finalname);
                storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(getApplicationContext(), "File successfully uploaded..", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Uploading Failed..", Toast.LENGTH_SHORT).show();
                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                        //TODO
                    }
                });


            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();

            }

        }




        super.onActivityResult(requestCode, resultCode, intent);
    }


    public static boolean isNetworkAvaliable(Context ctx) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if ((connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED)
                || (connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState() == NetworkInfo.State.CONNECTED)) {
            return true;
        } else {
            return false;
        }
    }


}

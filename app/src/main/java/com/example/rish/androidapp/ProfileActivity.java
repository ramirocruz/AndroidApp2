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


public class ProfileActivity extends AppCompatActivity {
    ListView listview;
    PDFAdapterWeb arraypdf;
//
   TextView textView;
  ProgressDialog progressDialog;
    Button btnlogout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
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
           Intent urlintent=new Intent(ProfileActivity.this,WebViewActivity.class);
            urlintent.putExtra("URL",listitemurl[position]);
            try{startActivity(urlintent);}catch (Exception e){
                Toast.makeText(ProfileActivity.this,"Here" + e.toString(),Toast.LENGTH_LONG).show();
            }
        }
    };

    private View.OnClickListener click=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(ProfileActivity.this,"Button Pressed",Toast.LENGTH_SHORT).show();
//            progressDialog.setMessage("Signing out...");
//            progressDialog.show();                                              // show the loading sign
//           // firebaseAuth.signOut();        //Sign out the firebase
//            finish();                     //End the current activity
//            startActivity(new Intent(ProfileActivity.this,LoginActivity.class));           //Start the activity LoginActivity     go to login page
        }
    };

    private final String[] listitemnames={"1.pdf","2.pdf","3.pdf","4.pdf"};
    private final String[] listitemurl={"https://drive.google.com/open?id=0ByNmy4jVMfU8S1MtVWI0bDZ5b2M","https://drive.google.com/open?id=0ByNmy4jVMfU8Z0NQTWkwNkQ5TEk"
    ,"https://drive.google.com/open?id=0ByNmy4jVMfU8RGhnTnVEc0NjcTg","https://drive.google.com/open?id=0ByNmy4jVMfU8X3RPbVVxN3d5UTQ"};
}

//    final String pathtofirebase="gs://androidapp-6745a.appspot.com/MathsOlympiad";
//    FirebaseAuth firebaseAuth;
//    StorageReference storagereference;
//    ListView listview;
//    ArrayAdapter<String> arraypdf;
//    Button btnlogout;
//    TextView textView;
//    ProgressDialog progressDialog;     //To see the progress when logging out
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile);
//        btnlogout=(Button)findViewById(R.id.logout);                                 //the logout button
//        textView=(TextView)findViewById(R.id.showemail);                            //shows email to screen
//        firebaseAuth= FirebaseAuth.getInstance();
//        progressDialog=new ProgressDialog(this);
//
//        Listview();
//        btnlogout.setOnClickListener(click);
//    }
//
//    private void Listview() {
//        storagereference= FirebaseStorage.getInstance().getReferenceFromUrl(pathtofirebase);
//
//       listview=(ListView)findViewById(R.id.theListView);
//        String fav[]={"Hello","World","How","Are","You"};
//        arraypdf=new ArrayAdapter<String>(ProfileActivity.this,android.R.layout.simple_list_item_1,fav);
//        listview.setAdapter(arraypdf);
//        listview.setOnItemClickListener(itemobject);
//    }
//    private AdapterView.OnItemClickListener itemobject=new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//        }
//    };
//    private HashMap<String,Object> testing(){
//        final HashMap<String,Object> hashmap =new HashMap<>();
//        StorageReference storagereference =FirebaseStorage.getInstance().getReference(pathtofirebase);
//
//        for(int i=1;;i++){
//            String path=i+".pdf";
//            final StringBuilder build=new StringBuilder();
//            StorageReference sref=storagereference.child(path);
//            sref.getMetadata().addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
//                @Override
//                public void onSuccess(StorageMetadata storageMetadata) {
//                 hashmap.put("Name",storageMetadata.getName());
//                    hashmap.put("StorageReference",storageMetadata.getReference());
//                    hashmap.put("Check",storageMetadata.getCustomMetadata("Check"));
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//
//                }
//            });
//            if((hashmap.get("Check").toString()=="last")){
//              break;
//            }
//        }
//    return  hashmap;}
//
//    private View.OnClickListener click=new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            progressDialog.setMessage("Signing out...");
//            progressDialog.show();                                              // show the loading sign
//            firebaseAuth.signOut();        //Sign out the firebase
//            finish();                     //End the current activity
//            startActivity(new Intent(ProfileActivity.this,LoginActivity.class));           //Start the activity LoginActivity     go to login page
//        }
//    };
//
//    private void itemdownload(String dfrom, String dto){
//       final String from=dfrom;
//        final String to=dto;
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(getApplicationContext(), "Download file ...", Toast.LENGTH_SHORT).show();
//                Thread th = new Thread(new Runnable() {
//                    public void run() {
//                        File file = new File(to + from.substring(from.lastIndexOf('.')));
//                        if (file.exists()) file.delete();
//                        try {
//                            FileOutputStream outputStream = new FileOutputStream(file);
//
//                            ProfileActivity.this.runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    Toast.makeText(getApplicationContext(), "File successfully downloaded.", Toast.LENGTH_SHORT).show();
//                                }
//                            });
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//                th.start();
//            }
//        });
//    }
//
// private void updatemetadata( String mto, String mkey,String mvalue){
//     final String to=mto,key=mkey,value=mvalue;
//     StorageReference sref=FirebaseStorage.getInstance().getReference();
//     StorageReference ref=sref.child(to);
//     StorageMetadata smeta=new StorageMetadata.Builder().setCustomMetadata(key,value).build();
//    ref.updateMetadata(smeta).addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
//        @Override
//        public void onSuccess(StorageMetadata storageMetadata) {
//         Toast.makeText(getApplicationContext(),"Updating metadata successful",Toast.LENGTH_SHORT).show();
//        }
//    }).addOnFailureListener(new OnFailureListener() {
//        @Override
//        public void onFailure(@NonNull Exception e) {
//            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
//        }
//    });
//
// }
// private ContentValues[] stringaraaybuilder(int number,String partialpath){
//     //final int no=number;
//     ContentValues[] contentvalues=new ContentValues[number];
//     for(int i=0;i<number;i++){
//         String path=partialpath+i;
//      contentvalues[i]=listbuilder(path);
//
//     }
//     return contentvalues;
// }
//
// private ContentValues listbuilder(String mto){
//     final String to=mto;
////     final StringBuilder sbf=new StringBuilder();
////     final StringBuilder sf=new StringBuilder();
//     final ContentValues content=new ContentValues();
//     String st;
//     StorageReference sref=FirebaseStorage.getInstance().getReference();
//     StorageReference ref=sref.child(to);
//     ref.getMetadata().addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
//
//         @Override
//         public void onSuccess(StorageMetadata storageMetadata) {
//           String string=storageMetadata.getName()+".pdf";
//             content.put("Name",string);
//             content.put("url",storageMetadata.getPath());
//         };
//     }).addOnFailureListener(new OnFailureListener() {
//         @Override
//         public void onFailure(@NonNull Exception e) {
//             Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
//         }
//     });
//
//
//  return content;
// }
// private StorageReference listitemdetector(ContentValues itemname) {
//     String s=itemname.get("url").toString();
//     return FirebaseStorage.getInstance().getReferenceFromUrl(s);
// }
//
//    }
//
//

package com.example.rish.androidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class DownloadListView extends AppCompatActivity {
    PDFAdapter pdfAdapter,pdfAdapter2;
    ListView questionlistview,solutionlistview;
    private String extrapath="Olympy/";
    private String downloaddirpath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_list_view);
//        Toast.makeText(getApplicationContext(),"Done1",Toast.LENGTH_SHORT).show();
        questionlistview=(ListView)findViewById(R.id.downloadquestionlistview);
        solutionlistview=(ListView)findViewById(R.id.downloadsolutionlistview);
        pdfAdapter=new PDFAdapter(this,getPDFs());
        pdfAdapter2=new PDFAdapter(this,getPDFs(),false);
        questionlistview.setAdapter(pdfAdapter);
        solutionlistview.setAdapter(pdfAdapter2);
//        Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();
    }





    private ArrayList<PDF> getPDFs()
    {
        ArrayList<PDF> pdfArrayList=new ArrayList<>();

        downloaddirpath="/storage/emulated/0/"+extrapath;
        File downloadsFolder= new File(downloaddirpath);
        PDF pdfDoc;
        if(downloadsFolder.exists())
        {
            //List of all files inside our download directory
            File[] files=downloadsFolder.listFiles();
            //get the path of each file one by one
            for (int i=0;i<files.length;i++)
            {
                File file=files[i];
                if(file.getPath().endsWith("pdf"))//TODO modify so only our app can open our pdf
                {
                    pdfDoc=new PDF();
                    pdfDoc.setName(file.getName());
                    pdfDoc.setPath(file.getAbsolutePath());
                    pdfArrayList.add(pdfDoc);
                }
            }
        }
        return pdfArrayList;
    }
}

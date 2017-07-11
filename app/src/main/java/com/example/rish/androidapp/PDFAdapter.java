package com.example.rish.androidapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ohanna on 09-Jul-17.
 */

public class PDFAdapter extends BaseAdapter {
   private ArrayList<PDF> PdfArrayList;
   private Context context;
   private boolean icon_status;
   private boolean empty_status;
    public PDFAdapter(Context context,ArrayList<PDF> pdfArrayList){
        this.context=context;
        this.PdfArrayList=pdfArrayList;
        this.icon_status=true;
        if(PdfArrayList.isEmpty())
            empty_status=true;
        else
            empty_status=false;
    }
    public PDFAdapter(Context context,ArrayList<PDF> pdfArrayList,boolean icon_status){
        this.context=context;
        this.PdfArrayList=pdfArrayList;
        this.icon_status=icon_status;
        if(PdfArrayList.isEmpty())
            empty_status=true;
        else
            empty_status=false;
    }
    @Override
    public int getCount() {
        return PdfArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return PdfArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.row_layout,parent,false);
        }
        final PDF pdfDoc= (PDF) this.getItem(position);
        TextView pdfname= (TextView) convertView.findViewById(R.id.pdfname);
        ImageView img= (ImageView) convertView.findViewById(R.id.pdficon);
        if(!empty_status) {
            pdfname.setText(pdfDoc.getName());

            if (icon_status)
                img.setImageResource(R.drawable.pdficon);
            else
                img.setImageResource(R.drawable.pdfsolutionicon);
        } else{
            pdfname.setText("Empty List");
            //img.setImageResource();
        }
        convertView.setOnClickListener(new View.OnClickListener() {    //on item click function will be called
            @Override
            public void onClick(View view) {
                openPDFView(pdfDoc.getPath());
            }
        });
        return convertView;
    }

    private void openPDFView(String path)        //To open a pdf viewer activity with a path
    {
//        Toast.makeText(context, "You Clicked", Toast.LENGTH_SHORT).show();
//      TODO : build pdf viewer activity
        Intent intent=new Intent(context,PdfViewerActivity.class);
        intent.putExtra("Path",path);
        context.startActivity(intent);
    }


}




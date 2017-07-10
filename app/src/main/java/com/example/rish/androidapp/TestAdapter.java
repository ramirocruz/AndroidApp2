package com.example.rish.androidapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ohanna on 09-Jul-17.
 */

class PDFAdapterWeb extends ArrayAdapter<String> {
    public PDFAdapterWeb(@NonNull Context context, String[] values) {
        super(context,R.layout.row_layout,values);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        View view=layoutInflater.inflate(R.layout.row_layout,parent,false);
        String item=getItem(position);
        TextView textView=(TextView)view.findViewById(R.id.pdfname);
        textView.setText(item);
        ImageView imageView=(ImageView)view.findViewById(R.id.pdficon);
        imageView.setImageResource(R.drawable.pdficon);

      return view;
    }
}

package com.example.rish.androidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreenActivity extends AppCompatActivity {
    Button buttonintroduction,buttonsyllabus,buttonquestionpapers,buttonbooks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        buttonintroduction=(Button)findViewById(R.id.buttonintroduction);
       buttonsyllabus=(Button)findViewById(R.id.buttonsyllabus);
        buttonquestionpapers=(Button)findViewById(R.id.buttonquestionpapers);
       buttonbooks=(Button)findViewById(R.id.buttonbooks);
       buttonbooks.setOnClickListener(clickobject);
        buttonintroduction.setOnClickListener(clickobject);
        buttonsyllabus.setOnClickListener(clickobject);
        buttonquestionpapers.setOnClickListener(clickobject);
    }

    private View.OnClickListener clickobject=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
      switch(v.getId()){

          case R.id.buttonintroduction:
              startActivity(new Intent(getApplicationContext(),IntroActivity.class));

              break;
          case R.id.buttonsyllabus:
              startActivity(new Intent(getApplicationContext(),SyllabusActivity.class));

              break;
          case R.id.buttonquestionpapers:
              startActivity(new Intent(getApplicationContext(),PreviousYearActivity.class));
              break;
          case R.id.buttonbooks:
              startActivity(new Intent(getApplicationContext(),BooksActivity.class));



      }
        }
    };

}

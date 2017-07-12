package com.example.rish.androidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SyllabusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        TextView textView = (TextView) findViewById(R.id.textViewSyllabus);
        textView.setText(syllabustext);
    }


    private final String syllabustext = "\"The syllabus for Mathematical Olympiad (regional, national and international) is pre-degree college mathematics.\n The areas covered are arithmetic of integers, geometry, quadratic equations and expressions, trigonometry, co-ordinate geometry, system of linear equations, permutations and combination, factorization of polynomial, inequalities, elementary combinatorics, probability theory and number theory, finite series and complex numbers and elementary graph theory.\n" +
            "The syllabus does not include calculus and statistics. The major areas from which problems are given are algebra, combinatorics, geometry and number theory . The syllabus is in a sense spread over Class XI to Class XII levels, but the problems under each topic involve high level of difficulty and sophistication. The difficulty level increases from RMO to INMO to IMO.\" />\n";

}


package com.example.rish.androidapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class IntroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        TextView textView= (TextView) findViewById(R.id.textViewIntroduction);
        textView.setText(introtext);
    }



  private final String introtext="The Mathematical Olympiad Programme in India, which leads to participation of Indian students in the International Mathematical Olympiad (IMO) is organized by the Homi Bhabha Centre for Science Education (HBCSE) on behalf of the National Board for Higher Mathematics (NBHM) of the Department of Atomic Energy (DAE), Government of India. This programme is one of the major initiatives undertaken by the NBHM. Its main purpose is to spot mathematical talent among pre-university students in the country.\n\nFor the purpose of training and selection of students for the Olympiad contest, 25 regions all over the country have been designated and each assigned a Regional Coordinator (RC). Additionally, three groups (Central Board of Secondary Education (CBSE), Navodaya Vidyalaya Samiti (NVS) and Kendriya Vidyalaya Sangathana (KVS) have a ‘Regional Coordinator’ each. The Mathematical Olympiad programme consists of six stages." +
          "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n    Stage 1:\nThe first stage examination, the pre-Regional Mathematical Olympiad (PRMO) is a two and half hour examination with 30 questions. The answer to each question is either a single digit number or a two digit number and will need to be marked on a machine readable OMR response sheet. The PRMO question paper will be in English and Hindi.            \n\nStage 2:\nThe second stage examination, the Regional Mathematical Olympiad (RMO) is a three hour examination with six problems. The RMOs are offered in English, Hindi and other regional languages as deemed appropriate by the respective Regional Coordinators. The syllabus may be found here. The problems under each topic involve high level of difficulty and sophistication.            \n\nStage 3:\nThe best-perfroming students from the RMO (approximately 900) qualify for the third stage – the Indian National Mathematical Olympiad (INMO). The INMO is held on the third Sunday of January at 28 centres across the " +
          "country.            \n\nStage 4:\nThe top students from the INMO (approximately 35) are invited for the fourth stage, the International Mathematical Olympiad Training Camp (IMOTC) held at HBCSE during April to May. At this camp orientation is provided to students for the International Mathematical Olympiad (IMO). Emphasis is laid on developing conceptual foundations and problem-solving skills. Several selection tests are held during this camp. On the basis of perfromance in these tests six students are selected to represent India at the IMO. Resource persons from different institutions across the country are invited to the training camps.            \n\nStage 5:\nThe selected team undergoes a rigorous training programme for about 8-10 days at HBCSE prior to its departure for the IMO.            \n\nStage 6:\nThe Olympiad programme culminates with the participation of the students in the IMO. The students are accompanied by 4 teachers or mentors." ;
}

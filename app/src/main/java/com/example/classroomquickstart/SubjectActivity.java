package com.example.classroomquickstart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SubjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        TextView tvSubjectID = (TextView)findViewById(R.id.tvSubID);

        tvSubjectID.setText("");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final String subjectID = extras.getString("subjectID");
            final String subjectName = extras.getString("subjectName");

            setTitle(subjectName);
            tvSubjectID.setText(subjectID);
        }
    }
}

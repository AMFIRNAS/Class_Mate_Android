package com.example.classroomquickstart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle("Subjects");








        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String[] CourseDetailsArray = extras.getStringArray("courses");
            final String[] CourseNameArray = new String[CourseDetailsArray.length];
            final String[] CourseIDArray = new String[CourseDetailsArray.length];
            for(int i = 0; i < CourseDetailsArray.length; i++){
                String[] parts = CourseDetailsArray[i].split("//");
                String subjectTitle = parts[0];
                String subjectID = parts[1];

                CourseNameArray[i] = subjectTitle;
                CourseIDArray[i] = subjectID;
            }

            ListAdapter subjectsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, CourseNameArray);
            ListView lvSubjects = (ListView)findViewById(R.id.subjectsListView);
            lvSubjects.setAdapter(subjectsAdapter);


            lvSubjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int selectedID = (int)parent.getItemIdAtPosition(position);
                    Intent int1 = new Intent(getApplicationContext(), SubjectActivity.class);
                    int1.putExtra("subjectID", CourseIDArray[selectedID]);
                    int1.putExtra("subjectName",CourseNameArray[selectedID]);
                    startActivityForResult(int1, 0);
                }
            });
        }
    }
}

package com.example.tema4;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView studentList;
    private StudentAdapter studentAdapter;
    private List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        students = new ArrayList<>();
        students.add(new Student("Faur"));
        students.add(new Student("Ionescu"));

        studentList = findViewById(R.id.student_list);
        studentAdapter = new StudentAdapter(students, this);

        studentList.setLayoutManager(new LinearLayoutManager(this));
        studentList.setAdapter(studentAdapter);
    }

    public void addStudent(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Student");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                students.add(new Student(input.getText().toString()));
                studentAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void removeStudent(View view) {
        // get the position of the item to be removed
        int position = studentList.getChildLayoutPosition((View) view.getParent());
        students.remove(position);
        studentAdapter.notifyDataSetChanged();
    }
}

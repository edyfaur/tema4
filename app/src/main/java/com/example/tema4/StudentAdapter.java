package com.example.tema4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private List<Student> students;
    private Context context;

    public StudentAdapter(List<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        holder.nameTextView.setText(students.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public void addStudent(Student student) {
        students.add(student);
        notifyItemInserted(students.size() - 1);
    }

    public void removeStudent(int position) {
        students.remove(position);
        notifyItemRemoved(position);
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        Button addButton;
        Button removeButton;

        public StudentViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_text_view);
            addButton = itemView.findViewById(R.id.add_button);
            removeButton = itemView.findViewById(R.id.remove_button);
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // add student
                }
            });
            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    removeStudent(position);
                }
            });
        }
    }
}

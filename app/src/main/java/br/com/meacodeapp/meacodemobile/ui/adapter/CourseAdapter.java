package br.com.meacodeapp.meacodemobile.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.meacodeapp.meacodemobile.R;
import br.com.meacodeapp.meacodemobile.model.Course;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseHolder> {

    Context context;
    List<Course> courses;

    public CourseAdapter(Context context, List<Course> courses){
        this.context = context;
        this.courses = courses;
    }

    public static class CourseHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        ImageView image;

        public CourseHolder(View itemView){
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.course_name);
            image = (ImageView) itemView.findViewById(R.id.course_image);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

        }
    }

    @Override
    public void onBindViewHolder(@NonNull CourseHolder holder, int position) {
        holder.name.setText(courses.get(position).getName());
        Glide.with(context).load(courses.get(position).getImage().getUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    @NonNull
    @Override
    public CourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_course, parent, false);
        return new CourseHolder(view);
    }
}

package govind.iiitl.app.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import govind.iiitl.app.Models.Faculty;
import govind.iiitl.app.R;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Faculty> list;

    public FacultyAdapter(Context context, ArrayList<Faculty> list) {
        this.context = context;
        this.list=list;
    }


    @NonNull
    @Override
    public FacultyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(R.layout.faculty_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FacultyAdapter.ViewHolder holder, int position) {
        Faculty faculty = list.get(position);
        holder.name.setText(faculty.getName());
        holder.description.setText(faculty.getDescription());
        holder.ResearchAreas.setText(faculty.getResearchAreas());
        Glide.with(context).load(faculty.getImgSrc()).into(holder.imgSrc);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgSrc;
        private TextView name;
        private TextView description;
        private TextView ResearchAreas;

        ViewHolder(View itemView) {
            super(itemView);

            imgSrc = itemView.findViewById(R.id.faculty_image);
            name = itemView.findViewById(R.id.faculty_name);
            description = itemView.findViewById(R.id.faculty_description);
            ResearchAreas = itemView.findViewById(R.id.faculty_research_areas);
        }
    }
}

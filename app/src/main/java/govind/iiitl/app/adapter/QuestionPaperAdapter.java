package govind.iiitl.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import govind.iiitl.app.R;
import govind.iiitl.app.models.Uploads;

public class QuestionPaperAdapter extends RecyclerView.Adapter<QuestionPaperAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Uploads> pdf;

    public QuestionPaperAdapter(Context context, ArrayList<Uploads> pdf) {
        this.context = context;
        this.pdf = pdf;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.question_paper,parent,false);
        return new QuestionPaperAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Uploads upload = pdf.get(position);
        Toast.makeText(context,upload.getUrl(),Toast.LENGTH_SHORT).show();
        holder.name.setText(upload.getName());
        holder.ll.setOnClickListener(v -> {
            Toast.makeText(context,upload.getName(),Toast.LENGTH_LONG).show();
//            Intent intent = new Intent();
//            intent.setData(Uri.parse(upload.getUrl()));
//            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return pdf.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private LinearLayout ll;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ll = itemView.findViewById(R.id.linear_pdf);
            name = itemView.findViewById(R.id.name);
        }
    }
}

package govind.iiitl.app.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.internal.InternalTokenProvider;

import java.util.List;

import govind.iiitl.app.R;
import govind.iiitl.app.models.QuestionPaper;

public class QuestionPaperAdapter extends RecyclerView.Adapter<QuestionPaperAdapter.ViewHolder> {
    private Context mContext;
    private List<QuestionPaper> questionPaperList;

    public QuestionPaperAdapter(Context mContext, List<QuestionPaper> questionPaperList) {
        this.mContext = mContext;
        this.questionPaperList = questionPaperList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.question_paper, parent, false);
        return new QuestionPaperAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final QuestionPaper questionPaper = questionPaperList.get(position);
        holder.name.setText(questionPaper.name);
        holder.pdf_click.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(questionPaper.url));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return questionPaperList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        CardView pdf_click;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            pdf_click = itemView.findViewById(R.id.linear_question);
        }
    }
}
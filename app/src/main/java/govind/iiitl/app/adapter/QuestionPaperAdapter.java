package govind.iiitl.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
    }

    @Override
    public int getItemCount() {
        return questionPaperList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
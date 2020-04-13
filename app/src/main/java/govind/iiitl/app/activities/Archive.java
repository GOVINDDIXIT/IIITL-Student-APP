package govind.iiitl.app.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import govind.iiitl.app.R;
import govind.iiitl.app.adapter.QuestionPaperAdapter;
import govind.iiitl.app.models.QuestionPaper;

public class Archive extends AppCompatActivity {

    private RecyclerView recyclerView;
    private QuestionPaperAdapter questionPaperAdapter;
    private List<QuestionPaper> questionPaperList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive);

        recyclerView = findViewById(R.id.recyclerview_pdf);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        questionPaperList = new ArrayList<>();
        questionPaperAdapter = new QuestionPaperAdapter(getApplicationContext(), questionPaperList);
        recyclerView.setAdapter(questionPaperAdapter);

        viewQuestionPaperList();

    }

    private void viewQuestionPaperList() {
        questionPaperList = new ArrayList<>();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("question_paper");
        //reference.keepSynced(true);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionPaperList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    QuestionPaper questionPaper = snapshot.getValue(QuestionPaper.class);
                    questionPaperList.add(questionPaper);
                }
                questionPaperAdapter = new QuestionPaperAdapter(getApplicationContext(), questionPaperList);
                recyclerView.setAdapter(questionPaperAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}

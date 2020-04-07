package govind.iiitl.app.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import govind.iiitl.app.R;
import govind.iiitl.app.adapter.QuestionPaperAdapter;
import govind.iiitl.app.models.Uploads;

public class Archieves extends AppCompatActivity {
    DatabaseReference reference;
    RecyclerView pdfView;
    QuestionPaperAdapter adapter;
    ArrayList<Uploads> retrievepdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archieves);

        pdfView = findViewById(R.id.recycler_viewpdf);
        retrievepdf = new ArrayList<>();
        viewAllPdf();

    }

    private void viewAllPdf() {
        reference = FirebaseDatabase.getInstance().getReference("question_paper");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s = "";
                for(DataSnapshot snapshots : dataSnapshot.getChildren()){
                    Uploads upload = snapshots.getValue(Uploads.class);
                    assert upload != null;
                    s=upload.getName();
                    retrievepdf.add(upload);
                }
                Toast.makeText(getApplicationContext(),Integer.toString(retrievepdf.size()), Toast.LENGTH_SHORT).show();
                adapter = new QuestionPaperAdapter(getApplicationContext(), retrievepdf);
                LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
                llm.setOrientation(LinearLayoutManager.VERTICAL);
                pdfView.setLayoutManager(llm);
                pdfView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

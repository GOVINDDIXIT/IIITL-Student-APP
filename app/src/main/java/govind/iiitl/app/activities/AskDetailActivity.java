package govind.iiitl.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import govind.iiitl.app.R;

public class AskDetailActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner yearone ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_detail);

        Spinner branch = findViewById(R.id.branch);
        ArrayAdapter<CharSequence> yearadapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.branch, R.layout.spinner_item);
        yearadapter.setDropDownViewResource(R.layout.spinner_item);
        branch.setAdapter(yearadapter);
        branch.setOnItemSelectedListener(this);

        yearone = findViewById(R.id.year);

        Button button = findViewById(R.id.ok_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String conc = null;
                String course = branch.getSelectedItem().toString();
                String yearse = yearone.getSelectedItem().toString();

                if(course.equals("CSE (B.Tech)")){
                    switch (yearse) {
                        case "1":
                            conc = "cs1sem.json";
                            break;
//                        case "2":
//                            conc = "cs2sem.json";
//                            break;
//                        case "3":
//                            conc = "cs3sem.json";
//                            break;
//                        case "4":
//                            conc = "cs4sem.json";
//                            break;
//                        case "5":
//                            conc = "cs5sem.json";
//                            break;
//                        case "6":
//                            conc = "cs6sem.json";
//                            break;
//                        case "7":
//                            conc = "cs7sem.json";
//                            break;
                        default:
                            conc = "cs2sem.json";
                            break;
                    }
                }else if(course.equals("IT (B.Tech)")){
                    switch (yearse) {
                        case "1":
                            conc = "it1sem.json";
                            break;
                        case "2":
                            conc = "it2sem.json";
                            break;
                        case "3":
                            conc = "it3sem.json";
                            break;
                        case "4":
                            conc = "it4sem.json";
                            break;
                        case "5":
                            conc = "it5sem.json";
                            break;
                        case "6":
                            conc = "it6sem.json";
                            break;
                        case "7":
                            conc = "it7sem.json";
                            break;
                        default:
                            conc = "it8sem.json";
                            break;
                    }
                }else {
                    switch (yearse) {
                        case "1":
                            conc = "mcs1sem.json";
                            break;
//                        case "2":
//                            conc = "cs2sem.json";
//                            break;
//                        case "3":
//                            conc = "cs3sem.json";
//                            break;
                        default:
                            conc = "mcs2sem.json";
                            break;
                    }
                }

                Intent intent = new Intent(AskDetailActivity.this, TimeTableActivity.class);
                intent.putExtra("cs2sem.json",conc);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String branchselect = adapterView.getItemAtPosition(i).toString();
        if ("CSE (M.Tech)".equals(branchselect) || "CSE (B.Tech)".equals(branchselect)) {
            Spinner yearone = findViewById(R.id.year);
            ArrayAdapter<CharSequence> yearadapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.mtech, R.layout.spinner_item);
            yearadapter.setDropDownViewResource(R.layout.spinner_item);
            yearone.setAdapter(yearadapter);
        } else {

            ArrayAdapter<CharSequence> yearadapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.year, R.layout.spinner_item);
            yearadapter.setDropDownViewResource(R.layout.spinner_item);
            yearone.setAdapter(yearadapter);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        /*
        Todo on nothing selected
         */
    }
}

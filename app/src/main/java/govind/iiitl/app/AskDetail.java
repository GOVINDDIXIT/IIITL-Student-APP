package govind.iiitl.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class AskDetail extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_detail);

        Spinner branch = findViewById(R.id.branch);
        ArrayAdapter<CharSequence> yearadapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.branch,android.R.layout.simple_spinner_item);
        yearadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branch.setAdapter(yearadapter);
        branch.setOnItemSelectedListener(this);

        Button button = findViewById(R.id.ok_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AskDetail.this,TimeTable.class));
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


        String branchselect = adapterView.getItemAtPosition(i).toString();
        if("CSE (M.Tech)".equals(branchselect)){
            Spinner yearone = findViewById(R.id.year);
            ArrayAdapter<CharSequence> yearadapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.mtech,android.R.layout.simple_spinner_item);
            yearadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            yearone.setAdapter(yearadapter);
        } else{
            Spinner yearone = findViewById(R.id.year);
            ArrayAdapter<CharSequence> yearadapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.year,android.R.layout.simple_spinner_item);
            yearadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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

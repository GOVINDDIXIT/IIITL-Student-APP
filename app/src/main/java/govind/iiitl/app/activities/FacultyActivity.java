package govind.iiitl.app.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import govind.iiitl.app.R;
import govind.iiitl.app.adapter.FacultyAdapter;
import govind.iiitl.app.models.Faculty;

public class  FacultyActivity extends AppCompatActivity {

    String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        ArrayList<Faculty> list = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(loadJSONFromAsset());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);

                String name = object.getString("name");
                String imgSrc = object.getString("imgSrc");
                String description = object.getString("description");
                String ResearchAreas = object.getString("ResearchAreas");

                //    hello = hello + "\n" + name +"\n" + imageURL +"\n"+ description +"\n"+ researchAreas + "\n";
                list.add(new Faculty(name, imgSrc, description, ResearchAreas));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        FacultyAdapter adapter = new FacultyAdapter(this, list);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }

    public String loadJSONFromAsset() {
        json = null;
        try {
            InputStream is = getAssets().open("faculty.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

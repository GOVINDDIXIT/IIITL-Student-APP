package govind.iiitl.app.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import govind.iiitl.app.Adapter.ListingAdapter;
import govind.iiitl.app.R;
import govind.iiitl.app.Schedule;
import govind.iiitl.app.TimeTable;

public class Wed extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_wed,null);
        TimeTable activity = (TimeTable) getActivity();
        assert activity != null;
        String s = activity.SendData();

        try {
            JSONObject obj = new JSONObject(loadJsonFromAsset(s));
            JSONObject wed = obj.getJSONObject("Wednesday");
            RecyclerView recyclerView = v.findViewById(R.id.rec_timetable);
            ArrayList<Schedule> list = new ArrayList<>();
            Iterator keysToCopyIterator = wed.keys();
            List<String> keysList = new ArrayList<>();
            while(keysToCopyIterator.hasNext()) {
                String key = (String) keysToCopyIterator.next();
                keysList.add(key);
            }

            for(int i=0;i<keysList.size();i++) {
                String morning9 = wed.getString(keysList.get(i));
                //  txt = txt + keysList.get(i)+ morning9 + "\n";
                list.add(new Schedule(keysList.get(i), morning9));
            }
            ListingAdapter adapter = new ListingAdapter(getContext(), list);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return v;

    }
    private String loadJsonFromAsset(String s){
        String json = null;
        try{
            InputStream in = Objects.requireNonNull(getContext()).getAssets().open("timetable/"+s);
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            json = new String(buffer, "UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}

package govind.iiitl.app.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Objects;

import govind.iiitl.app.R;
import govind.iiitl.app.TimeTable;

public class Thu extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_thu,null);
        TimeTable activity = (TimeTable) getActivity();
        assert activity != null;
        String s = activity.SendData();
        TextView txt1 = v.findViewById(R.id.textView1);
        TextView txt2 = v.findViewById(R.id.textView2);
        TextView txt3 = v.findViewById(R.id.textView3);
        TextView txt4 = v.findViewById(R.id.textView4);
        TextView txt5 = v.findViewById(R.id.textView5);

        try {
            JSONObject obj = new JSONObject(loadJsonFromAsset(s));
            JSONObject thu = obj.getJSONObject("Thursday");
            for(int i=0;i<thu.length();i++){
                String morning9 = thu.getString("9:00-10:00");
                String morning10 = thu.getString("10:00-11:00");
                String morning12 = thu.getString("11:15-12:15");
                String morning2 = thu.getString("12:15-1:15");
                String morning = thu.getString("3:00-6:00");

                txt1.setText(morning9);
                txt2.setText(morning10);
                txt3.setText(morning12);
                txt4.setText(morning2);
                txt5.setText(morning);
            }

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

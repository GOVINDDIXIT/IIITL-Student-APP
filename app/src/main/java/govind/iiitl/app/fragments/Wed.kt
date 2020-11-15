package govind.iiitl.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import govind.iiitl.app.R
import govind.iiitl.app.activities.TimeTableActivity
import govind.iiitl.app.adapter.ListingAdapter
import govind.iiitl.app.models.Schedule
import govind.iiitl.app.utils.loadJsonFromAsset
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class Wed : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = LayoutInflater.from(context).inflate(R.layout.fragment_wed, null)
        val activity = (activity as TimeTableActivity?)!!
        val s = activity.SendData()
        try {
            val obj = JSONObject(getActivity()?.let { loadJsonFromAsset(s, it) })
            val wed = obj.getJSONObject("Wednesday")
            val recyclerView: RecyclerView = v.findViewById(R.id.rec_timetable)
            val list = ArrayList<Schedule>()
            val keysToCopyIterator: Iterator<*> = wed.keys()
            val keysList: MutableList<String> = ArrayList()
            while (keysToCopyIterator.hasNext()) {
                val key = keysToCopyIterator.next() as String
                keysList.add(key)
            }
            for (i in keysList.indices) {
                val morning9 = wed.getString(keysList[i])
                //  txt = txt + keysList.get(i)+ morning9 + "\n";
                list.add(Schedule(keysList[i], morning9))
            }
            val adapter = context?.let { ListingAdapter(it, list) }
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return v
    }
}
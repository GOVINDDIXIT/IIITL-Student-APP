package govind.iiitl.app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import govind.iiitl.app.R
import govind.iiitl.app.models.Schedule

class ListingAdapter(private val context: Context, private val list: List<Schedule>) : RecyclerView.Adapter<ListingAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.timetable, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val time = list[position]
        holder.time.text = time.time
        holder.period.text = time.period
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var time: TextView = itemView.findViewById(R.id.time)
        var period: TextView = itemView.findViewById(R.id.period)
    }
}
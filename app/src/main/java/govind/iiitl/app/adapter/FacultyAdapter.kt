package govind.iiitl.app.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.facebook.shimmer.ShimmerFrameLayout
import govind.iiitl.app.R
import govind.iiitl.app.models.Faculty
import java.util.*

class FacultyAdapter(private val context: Context, private val list: ArrayList<Faculty>) : RecyclerView.Adapter<FacultyAdapter.ViewHolder>() {
    @JvmField
    var shimmer = true
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        @SuppressLint("InflateParams") val view = LayoutInflater.from(context).inflate(R.layout.faculty_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (shimmer) {
            holder.shimmerFrameLayout.startShimmer()
        } else {
            holder.shimmerFrameLayout.stopShimmer()
            holder.shimmerFrameLayout.setShimmer(null)
            val faculty = list[position]
            holder.name.background = null
            holder.name.text = faculty.name
            holder.description.background = null
            holder.description.text = faculty.description
            holder.imgSrc.background = null
            holder.researchAreas.background = null
            holder.researchAreas.text = faculty.researchAreas
            Glide.with(context).load(faculty.imgSrc).into(holder.imgSrc)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgSrc: ImageView = itemView.findViewById(R.id.faculty_image)
        val name: TextView = itemView.findViewById(R.id.faculty_name)
        val description: TextView = itemView.findViewById(R.id.faculty_description)
        val researchAreas: TextView = itemView.findViewById(R.id.faculty_research_areas)
        val shimmerFrameLayout: ShimmerFrameLayout = itemView.findViewById(R.id.shimmerlayoutt)
    }
}
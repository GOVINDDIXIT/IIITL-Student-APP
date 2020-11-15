package govind.iiitl.app.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.facebook.shimmer.ShimmerFrameLayout
import govind.iiitl.app.R
import govind.iiitl.app.activities.DetailActivity
import govind.iiitl.app.adapter.PostAdapter.PostViewHolder
import govind.iiitl.app.models.Item
import org.jsoup.Jsoup

class PostAdapter(private val context: Context, private val items: List<Item>) : RecyclerView.Adapter<PostViewHolder>() {
    var showshmmer = true
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.post_item, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        if (showshmmer) {
            holder.shimmerFrameLayout.startShimmer()
        } else {
            holder.shimmerFrameLayout.stopShimmer()
            holder.shimmerFrameLayout.setShimmer(null)
            val item = items[position]
            holder.postTitle.background = null
            holder.postTitle.text = item.title
            holder.postDescription.background = null
            holder.postDescription.text = item.content

            //Using Jsoup to parse html in order to get images and text
            val document = Jsoup.parse(item.content)
            val elements = document.select("img")
            holder.postDescription.text = document.text()

            //To get images
            //Log.d("Code","image-"+elements.get(0).attr("src"));
            //To get Text
            //Log.d("Text",document.text());
            holder.postImage.background = null
            Glide.with(context).load(elements[0].attr("src")).into(holder.postImage)
            holder.itemView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("url", item.url)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val shimmerFrameLayout: ShimmerFrameLayout = itemView.findViewById(R.id.shimmerlayout)
        val postImage: ImageView = itemView.findViewById(R.id.postImage)
        val postTitle: TextView = itemView.findViewById(R.id.postTitle)
        val postDescription: TextView = itemView.findViewById(R.id.postdescription)
    }
}
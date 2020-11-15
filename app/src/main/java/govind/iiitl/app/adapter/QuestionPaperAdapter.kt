package govind.iiitl.app.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import govind.iiitl.app.R
import govind.iiitl.app.models.QuestionPaper

class QuestionPaperAdapter(private val mContext: Context, private val questionPaperList: List<QuestionPaper>) : RecyclerView.Adapter<QuestionPaperAdapter.ViewHolder>() {
    @JvmField
    var shimmer = true
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.question_paper, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (shimmer) {
            holder.shimmerFrameLayout.startShimmer()
        } else {
            holder.shimmerFrameLayout.stopShimmer()
            holder.shimmerFrameLayout.setShimmer(null)
            val questionPaper = questionPaperList[position]
            holder.name.background = null
            holder.name.text = questionPaper.name
            holder.qPaperCView.setOnClickListener {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(questionPaper.url))
                browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                mContext.startActivity(browserIntent)
            }
        }
    }

    override fun getItemCount(): Int {
        return questionPaperList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val shimmerFrameLayout: ShimmerFrameLayout = itemView.findViewById(R.id.shimmerlayout)
        val name: TextView = itemView.findViewById(R.id.name)
        val qPaperCView: CardView = itemView.findViewById(R.id.linear_question)
    }
}
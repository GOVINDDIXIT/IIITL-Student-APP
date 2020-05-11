package govind.iiitl.app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

import govind.iiitl.app.R;
import govind.iiitl.app.activities.DetailActivity;
import govind.iiitl.app.models.Item;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private Context context;
    private List<Item> items;
    public boolean showshmmer = true;

    public PostAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.post_item,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        if(showshmmer){
            holder.shimmerFrameLayout.startShimmer();
        }else{
            holder.shimmerFrameLayout.stopShimmer();
            holder.shimmerFrameLayout.setShimmer(null);

            final Item item =items.get(position);
            holder.postTitle.setBackground(null);
            holder.postTitle.setText(item.getTitle());
            holder.postDescription.setBackground(null);
            holder.postDescription.setText(item.getContent());

            //Using Jsoup to parse html in order to get images and text
            Document document =  Jsoup.parse(item.getContent());
            Elements elements = document.select("img");
            holder.postDescription.setText((document.text()));

            //To get images
            //Log.d("Code","image-"+elements.get(0).attr("src"));
            //To get Text
            //Log.d("Text",document.text());
            holder.postImage.setBackground(null);
            Glide.with(context).load(elements.get(0).attr("src")).into(holder.postImage);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent (context,DetailActivity.class);
                    intent.putExtra("url",item.getUrl());
                    context.startActivity(intent);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return  items.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder{
        private ShimmerFrameLayout shimmerFrameLayout;
        private ImageView postImage;
        private TextView postTitle;
        private TextView postDescription;

        PostViewHolder(View itemView){
            super(itemView);
            shimmerFrameLayout = itemView.findViewById(R.id.shimmerlayout);
            postImage = itemView.findViewById(R.id.postImage);
            postTitle=itemView.findViewById(R.id.postTitle);
            postDescription=itemView.findViewById(R.id.postdescription);
        }

    }

}

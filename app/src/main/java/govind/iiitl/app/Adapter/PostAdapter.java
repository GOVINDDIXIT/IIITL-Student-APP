package govind.iiitl.app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

import govind.iiitl.app.DetailActivity;
import govind.iiitl.app.Models.Item;
import govind.iiitl.app.R;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private Context context;
    private List<Item> items;

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
        final Item item =items.get(position);
        holder.postTitle.setText(item.getTitle());
        holder.postDescription.setText(item.getContent());


        //Using Jsoup to parse html in order to get images and text
        Document document =  Jsoup.parse(item.getContent());
        Elements elements = document.select("img");
        holder.postDescription.setText((document.text()));

        //To get images
        //Log.d("Code","image-"+elements.get(0).attr("src"));
        //To get Text
        //Log.d("Text",document.text());
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

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        ImageView postImage;
        TextView postTitle;
        TextView postDescription;

        public PostViewHolder(View itemView){
            super(itemView);
            postImage=itemView.findViewById(R.id.postImage);
            postTitle=itemView.findViewById(R.id.postTitle);
            postDescription=itemView.findViewById(R.id.postdescription);
        }

    }

}

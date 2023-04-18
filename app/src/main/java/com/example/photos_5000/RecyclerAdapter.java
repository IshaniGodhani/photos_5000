package com.example.photos_5000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.View_Holder> {

    Context context;
    ArrayList<Datamodel> list;

    public RecyclerAdapter(Context context, ArrayList<Datamodel> list) {
            this.context=context;
            this.list=list;
    }

    @NonNull
    @Override
    public RecyclerAdapter.View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_imgfile,parent,false);
        View_Holder viewHolder=new View_Holder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.View_Holder holder, int position) {
        Datamodel datamodel=list.get(position);

        int aid= datamodel.getAlbumId();
        int id= datamodel.getId();
        String title=datamodel.getTitle();
        String url=datamodel.getUrl();
        String thumbnail=datamodel.getThumbnailUrl();

        holder.AlbumId.setText(""+aid);
        holder.Id.setText(""+id);
        holder.Title.setText(""+title);
        holder.Url.setText(""+url);
        holder.Thumbnail.setText(""+thumbnail);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class View_Holder extends RecyclerView.ViewHolder {
        TextView AlbumId,Id,Title,Url,Thumbnail;
        public View_Holder(@NonNull View itemView) {
            super(itemView);
            AlbumId=itemView.findViewById(R.id.item_aid);
            Id=itemView.findViewById(R.id.item_id);
            Title=itemView.findViewById(R.id.item_title);
            Url=itemView.findViewById(R.id.item_url);
            Thumbnail=itemView.findViewById(R.id.item_thumbnailUrl);
        }
    }
}

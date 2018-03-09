package com.madsum.shopcite;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Madhav on 12/29/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<CreateList> galleryList;
    private Context context;


    public MyAdapter(Context context, ArrayList<CreateList> galleryList) {
        this.galleryList = galleryList;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_layout, viewGroup, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final MyAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(galleryList.get(i).getImage_title());
        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER);
        viewHolder.img.setImageResource((galleryList.get(i).getImage_ID()));
        // Picasso.with(context).load(galleryList.get(i).getImage_ID()).fit().into(viewHolder.img);
        Glide
                .with(context)
                .load(galleryList.get(i).getImage_ID())
                .fitCenter()
                .crossFade()
                .into(viewHolder.img);

    }
    @Override
    public int getItemCount() {
        return galleryList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title;
        public ImageView img;
        private final Context context;
        public ViewHolder(View view) {
            super(view);

            title = (TextView)view.findViewById(R.id.title);
            img = (ImageView) view.findViewById(R.id.img);
            context=view.getContext();
            view.setClickable(true);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            final Intent intent;
            int position=getAdapterPosition();
            switch (position){
                case 0:
                    intent =  new Intent(context, ElecShopView.class);
                    break;

                case 1:
                    intent =  new Intent(context, ElecShopViewTwo.class);
                    break;
                default:
                    intent =  new Intent(context, ElecShopView.class);
                    break;
            }
            context.startActivity(intent);

        }
        }
    }



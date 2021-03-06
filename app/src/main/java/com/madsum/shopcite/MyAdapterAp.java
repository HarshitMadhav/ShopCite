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

public class MyAdapterAp extends RecyclerView.Adapter<MyAdapterAp.ViewHolder> {
    private ArrayList<CreateList> galleryList;
    private Context context;


    public MyAdapterAp(Context context, ArrayList<CreateList> galleryList) {
        this.galleryList = galleryList;
        this.context = context;
    }

    @Override
    public MyAdapterAp.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_layout, viewGroup, false);
        final MyAdapterAp.ViewHolder holder= new MyAdapterAp.ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                final Intent intent;
                switch (position){
                    case 0:
                        intent= new Intent(context, ElecShopView.class);
                        break;
                    case 1:
                        intent = new Intent(context, ElecShopView.class);
                        break;

                    case 2:
                        intent = new Intent(context, ApShopView.class);
                        break;
                    default: intent=new Intent(context, ApShopView.class);
                        break;
                }
                context.startActivity(intent);
            }
        });
        return new MyAdapterAp.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final MyAdapterAp.ViewHolder viewHolder, int i) {
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



    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView img;
        public ViewHolder(View view) {
            super(view);

            title = (TextView)view.findViewById(R.id.title);
            img = (ImageView) view.findViewById(R.id.img);
            context=view.getContext();
        }
    }


}

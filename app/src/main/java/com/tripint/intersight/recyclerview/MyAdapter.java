package com.tripint.intersight.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tripint.intersight.R;

import java.util.List;

/**
 * Created by Eric on 16/3/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Product> products;

    public MyAdapter(List<Product> products) {
        this.products = products;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(products.get(position).getImg());
        holder.textView.setText(products.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = ((ImageView) itemView.findViewById(R.id.iv));
            textView = ((TextView) itemView.findViewById(R.id.title));
        }

    }
}

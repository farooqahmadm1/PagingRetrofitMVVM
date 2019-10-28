package com.example.pagingretrofitmvvm.Adapter;

import android.annotation.SuppressLint;
import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pagingretrofitmvvm.R;
import com.example.pagingretrofitmvvm.Item;


public class ItemAdapter extends PagedListAdapter<Item, ItemAdapter.ItemViewHolder> {


    Context context;

    public ItemAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_users, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int i) {
        Item item = getItem(i);

        if (item != null){
            holder.textView.setText(item.owner.display_name);
            Glide.with(context).load(item.owner.profile_image).into(holder.imageView);
        }else {
            Toast.makeText(context, "Item are Empty", Toast.LENGTH_SHORT).show();
        }
    }

    public static DiffUtil.ItemCallback<Item> DIFF_CALLBACK = new DiffUtil.ItemCallback<Item>() {
        @Override
        public boolean areItemsTheSame(@NonNull Item item, @NonNull Item t1) {
            return item.question_id == t1.question_id;
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(Item oldItem,Item newItem) {
            return oldItem.equals(newItem);
        }
    };

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textViewName);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}

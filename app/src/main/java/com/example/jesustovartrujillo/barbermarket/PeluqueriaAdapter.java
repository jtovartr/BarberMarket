package com.example.jesustovartrujillo.barbermarket;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PeluqueriaAdapter extends RecyclerView.Adapter<PeluqueriaAdapter.PeluqueriaViewHolder> {

    private Context mContext;
    private ArrayList<Peluqueria> mPeluqueriaList;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public PeluqueriaAdapter(Context context, ArrayList<Peluqueria>peluqueriaList) {
        this.mContext = context;
        this.mPeluqueriaList = peluqueriaList;
    }

    @NonNull
    @Override
    public PeluqueriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_cardview, parent, false);
        return new PeluqueriaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PeluqueriaViewHolder holder, int position) {
        Peluqueria currentItem = mPeluqueriaList.get(position);

        String imageUrl = currentItem.getImageUrl();
        String name = currentItem.getName();

        holder.mTextViewName.setText(name);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mPeluqueriaList.size();
    }

    public class PeluqueriaViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextViewName;

        public PeluqueriaViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewName = itemView.findViewById(R.id.text_view_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

}

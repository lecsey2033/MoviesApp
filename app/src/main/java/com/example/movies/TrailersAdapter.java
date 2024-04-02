package com.example.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.TrailersViewHolder> {

    private List<Trailer> trailers = new ArrayList<>();
    private OnTrailerClickListener onTrailerClickListener;

    public void setTrailers(List<Trailer> trailers) {

        this.trailers = trailers;
        notifyDataSetChanged();
    }

    public void setOnTrailerClickListener(OnTrailerClickListener onTrailerClickListener) {
        this.onTrailerClickListener = onTrailerClickListener;
    }

    @NonNull
    @Override
    public TrailersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.trailer_item,
                parent,
                false
        );
        return new TrailersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailersViewHolder holder, int position) {
        Trailer trailer = trailers.get(position);
        holder.nameTrailer.setText(trailer.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTrailerClickListener != null) {
                    onTrailerClickListener.onTrailerClick(trailer);
                }
            }
        });
    }

    interface OnTrailerClickListener {
        void onTrailerClick(Trailer trailer);
    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }

    static class TrailersViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameTrailer;
        public TrailersViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTrailer = itemView.findViewById(R.id.textViewTrailerName);
        }
    }
}

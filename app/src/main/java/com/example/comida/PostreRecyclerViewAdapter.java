package com.example.comida;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comida.network.ImageRequester;
import com.example.comida.network.PostreEntry;

import java.util.List;

public class PostreRecyclerViewAdapter extends RecyclerView.Adapter<PostreItemViewHolder> {

    private List<PostreEntry> postreEntryList;

    public PostreRecyclerViewAdapter(List<PostreEntry> postreEntryList) {
        this.postreEntryList = postreEntryList;
    }

    @NonNull
    @Override
    public PostreItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postre_card, parent, false);
        return new PostreItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostreItemViewHolder holder, int position) {
        PostreEntry postreEntry = postreEntryList.get(position);
        ImageRequester.getInstance().setImageFromUrl(holder.imageView, postreEntry.getImagenUrl());
        holder.nombreTextView.setText(postreEntry.getNombre());
        holder.precioTextView.setText("S/. " + String.format("%.2f", postreEntry.getPrecio()));
    }

    @Override
    public int getItemCount() {
        return postreEntryList.size();
    }
}

package com.example.comida;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class PostreItemViewHolder extends RecyclerView.ViewHolder {

    public NetworkImageView imageView;
    public TextView nombreTextView;
    public TextView precioTextView;

    public PostreItemViewHolder(@NonNull View itemView) {
        super(itemView);

        this.imageView = itemView.findViewById(R.id.postre_image_view);
        this.nombreTextView = itemView.findViewById(R.id.postre_nombre);
        this.precioTextView = itemView.findViewById(R.id.postre_precio);
    }
}

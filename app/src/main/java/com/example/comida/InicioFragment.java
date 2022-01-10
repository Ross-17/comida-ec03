package com.example.comida;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comida.network.PostreEntry;

public class InicioFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inicio_fragment, container, false);
        RecyclerView postreRecyclerView = view.findViewById(R.id.postre_recycler_view);
        postreRecyclerView.setHasFixedSize(true);
        postreRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        postreRecyclerView.setAdapter(new PostreRecyclerViewAdapter(PostreEntry.initPostreEntryList(getResources())));

        int postreEspacio = getResources().getDimensionPixelSize(R.dimen.postre_item_decoration_spacing);
        postreRecyclerView.addItemDecoration(new PostreItemDecoration(postreEspacio));

        return view;
    }
}

package com.example.pruebacontacts;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentListado extends Fragment {
    private Contacto[] datos;
    private IClickListener listener;

    public FragmentListado() {
        super(R.layout.fragment_listado);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert datos != null && listener != null;
        RecyclerView rVListado = view.findViewById(R.id.rVListado);
        rVListado.setAdapter(new AdaptadorContactos(datos, listener));
        rVListado.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    public void setContactosListener(Contacto[] contactos, IClickListener listener) {
        this.datos = contactos;
        this.listener = listener;
    }
}

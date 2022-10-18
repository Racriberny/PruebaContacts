package com.example.pruebacontacts;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.Objects;

public class DetalleActivity extends AppCompatActivity {

    public static final String EXTRA_TEXTO = "Esto_es_un_extra_texto.EXTRA_TEXTO";

    public DetalleActivity() {

        super(R.layout.activity_detalle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null) {
            Contacto contacto = (Contacto) Objects.requireNonNull(getIntent().getSerializableExtra(EXTRA_TEXTO));
            Bundle bundle = new Bundle();
            bundle.putSerializable(FragmentDetalle.EXTRA_CONTACTO, contacto);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.FrgDetalle, FragmentDetalle.class, bundle)
                    .commit();
        }
    }
}

package com.mnunes.misdatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ConfirmacionDatos extends AppCompatActivity {

    public String dia;
    public String mes;
    public String anio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos);

        Bundle parametros = getIntent().getExtras();
        final String nombre_completo = parametros.getString( getResources().getString(R.string.bundle_nombre_completo));

        dia = parametros.getString( getResources().getString(R.string.bundle_dia));
        mes = parametros.getString( getResources().getString(R.string.bundle_mes));
        anio = parametros.getString( getResources().getString(R.string.bundle_anio));

        final String fecha =    dia + " / " + mes + " / " + anio;

        final String telefono = parametros.getString( getResources().getString(R.string.bundle_telefono));
        final String email = parametros.getString( getResources().getString(R.string.bundle_email));
        final String descripcion = parametros.getString( getResources().getString(R.string.bundle_descripcion));

        TextView tvNombre = (TextView) findViewById(R.id.tvConfirmaNombre);
        TextView tvFecha = (TextView) findViewById(R.id.tvConfirmaFecha);
        TextView tvTelefono = (TextView) findViewById(R.id.tvConfirmaTelefono);
        TextView tvEmail = (TextView) findViewById(R.id.tvConfirmaEmail);
        TextView tvDescripcion = (TextView) findViewById(R.id.tvConfirmaDescripcion);

        tvNombre.setText(nombre_completo);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);


        Button boton_editar = findViewById(R.id.boton_editar);
        boton_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent( ConfirmacionDatos.this, MainActivity.class);
                i.putExtra( getResources().getString(R.string.bundle_dia), dia );
                i.putExtra( getResources().getString(R.string.bundle_mes), mes );
                i.putExtra( getResources().getString(R.string.bundle_anio), anio );
                setResult(1, i);
                finish();
            }
        });
    }
}
package com.mnunes.misdatos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if ( savedInstanceState != null )
        {

            int dia                         = Integer.parseInt(savedInstanceState.getString( getResources().getString(R.string.bundle_dia)));
            int mes                         = Integer.parseInt(savedInstanceState.getString( getResources().getString(R.string.bundle_mes)));
            int anio                        = Integer.parseInt(savedInstanceState.getString( getResources().getString(R.string.bundle_anio)));

            EditText et_nombre_completo     = (EditText)findViewById(R.id.etNombreCompleto);
            DatePicker dp_fecha             = (DatePicker) findViewById(R.id.dtFechaNacimiento);
            EditText et_telefono            = (EditText)findViewById(R.id.etTelefono);
            EditText et_email               = (EditText)findViewById(R.id.etEmail);
            EditText et_descripcion         = (EditText)findViewById(R.id.etDescripcionContacto);

            et_nombre_completo.setText(savedInstanceState.getString( getResources().getString(R.string.bundle_nombre_completo ) ));
            dp_fecha.updateDate( anio, mes, dia );
            et_telefono.setText(savedInstanceState.getString( getResources().getString(R.string.bundle_telefono ) ));
            et_email.setText(savedInstanceState.getString( getResources().getString(R.string.bundle_email ) ));
            et_descripcion.setText(savedInstanceState.getString( getResources().getString(R.string.bundle_descripcion ) ));
        }

        Button boton_enviar = (Button) findViewById(R.id.boton_enviar);
        boton_enviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText et_nombre_completo     = (EditText)findViewById(R.id.etNombreCompleto);
                DatePicker dp_fecha             = (DatePicker) findViewById(R.id.dtFechaNacimiento);
                EditText et_telefono            = (EditText)findViewById(R.id.etTelefono);
                EditText et_email               = (EditText)findViewById(R.id.etEmail);
                EditText et_descripcion         = (EditText)findViewById(R.id.etDescripcionContacto);

                Intent i                        = new Intent(MainActivity.this, ConfirmacionDatos.class);

                i.putExtra( getResources().getString(R.string.bundle_nombre_completo), et_nombre_completo.getText().toString());
                i.putExtra( getResources().getString(R.string.bundle_dia), String.valueOf(dp_fecha.getDayOfMonth()));
                i.putExtra( getResources().getString(R.string.bundle_mes), String.valueOf(dp_fecha.getMonth()));
                i.putExtra( getResources().getString(R.string.bundle_anio), String.valueOf(dp_fecha.getYear()));
                i.putExtra( getResources().getString(R.string.bundle_telefono),et_telefono.getText().toString());
                i.putExtra( getResources().getString(R.string.bundle_email),et_email.getText().toString());
                i.putExtra( getResources().getString(R.string.bundle_descripcion),et_descripcion.getText().toString());

                startActivityForResult(i, 1);
            }
        });
    }
}
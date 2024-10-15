package com.example.pablo_gonzalez_ruiz_pmdm_tarea1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ModifiacarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modificar_datos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Recuperamos los elementos de la vista
        EditText editTextNuevoNombre = findViewById(R.id.editTextNuevoNombre);
        EditText editTextNuevaContrasenia = findViewById(R.id.editTextNuevaContrasenia);
        Button btnGuardarCambios = findViewById(R.id.btnGuardarCambios);

        editTextNuevoNombre.setText(getIntent().getStringExtra("user"));
        editTextNuevaContrasenia.setText(getIntent().getStringExtra("password"));


        btnGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent modificarDatos = new Intent();
                modificarDatos.putExtra("user", editTextNuevoNombre.getText().toString());
                modificarDatos.putExtra("password", editTextNuevaContrasenia.getText().toString());
                setResult(RESULT_OK, modificarDatos);
                finish();
            }
        });
    }
}
package com.example.pablo_gonzalez_ruiz_pmdm_tarea1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LogInCorrect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in_correct);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //Añadimos los elementos de la interfaz para recuperar el nombre del logIn

        String nombreUsuario = getIntent().getStringExtra("NombreUsuario");
        TextView textViewWelcome= findViewById(R.id.textViewWelcome);
        String welcomeMessage = getString(R.string.lblWelcome) + " " + nombreUsuario;
        textViewWelcome.setText(welcomeMessage);

    }
}
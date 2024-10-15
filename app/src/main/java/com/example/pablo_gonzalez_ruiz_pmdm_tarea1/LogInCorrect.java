package com.example.pablo_gonzalez_ruiz_pmdm_tarea1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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


//Añadimos los elementos de la interfaz para recuperar el nombre del logIn y mostrarlo
        String nombreUsuario = getIntent().getStringExtra("NombreUsuario");
        TextView textViewWelcome = findViewById(R.id.textViewWelcome);
        String welcomeMessage = getString(R.string.lblWelcome) + " " + nombreUsuario;
        textViewWelcome.setText(welcomeMessage);

//Añadimos el boton para configurar una alarma
        Button btnAlarma = findViewById(R.id.btnAlarma);

        btnAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent configurarAlarma = new Intent(LogInCorrect.this, Alarma.class);
                startActivity(configurarAlarma);
            }
        });

//Añadimos el boton para redirigir a la pagina web
        ImageButton btnPaginaWeb = findViewById(R.id.btnPaginaWeb);
        btnPaginaWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirPaginaWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "https://www.tutorialspoint.com/android/android_intents_filters.htm"));
                startActivity(abrirPaginaWeb);
            }
        });
    }
}
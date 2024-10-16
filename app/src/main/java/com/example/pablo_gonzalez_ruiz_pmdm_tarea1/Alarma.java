package com.example.pablo_gonzalez_ruiz_pmdm_tarea1;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.nio.channels.InterruptedByTimeoutException;

public class Alarma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alarma);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Recuperamos los elementos de la vista
        EditText editTextNombreAlarma = findViewById(R.id.editTextNombreAlarma);
        EditText editTextHoraAlarma = findViewById(R.id.editTextHoraAlarma);
        EditText editTextMinutosAlarma = findViewById(R.id.editTextMinutosAlarma);
        Button btnCrearAlarma = findViewById(R.id.btnCrearAlarma);



        btnCrearAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int hora = Integer.parseInt(editTextHoraAlarma.getText().toString());
                int minutos = Integer.parseInt(editTextMinutosAlarma.getText().toString());

                Intent crearAlarma = new Intent(AlarmClock.ACTION_SET_ALARM);
                crearAlarma.putExtra(AlarmClock.EXTRA_MESSAGE, editTextNombreAlarma.getText().toString());
                crearAlarma.putExtra(AlarmClock.EXTRA_HOUR, hora);
                crearAlarma.putExtra(AlarmClock.EXTRA_MINUTES, minutos);
                startActivity(crearAlarma);
            }
        });
    }

}

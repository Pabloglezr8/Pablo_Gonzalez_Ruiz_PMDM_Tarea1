package com.example.pablo_gonzalez_ruiz_pmdm_tarea1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextPswrd = findViewById(R.id.editTextPswrd);
        Button btnLogIn = findViewById(R.id.btnLogIn);

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextName.getText().toString().equals("admin") && editTextPswrd.getText().toString().equals("admin")){
                    Intent iniciarSesion = new Intent(LogIn.this, LogInCorrect.class);
                    iniciarSesion.putExtra("NombreUsuario", editTextName.getText().toString());
                    startActivity(iniciarSesion);
                }else {
                    //se crea  un toast par indicar q los campos son incorrectos
                    Toast.makeText(LogIn.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
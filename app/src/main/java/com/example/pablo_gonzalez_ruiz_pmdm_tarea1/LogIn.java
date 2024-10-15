package com.example.pablo_gonzalez_ruiz_pmdm_tarea1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LogIn extends AppCompatActivity {

    //Declaramos una variable para guardar el usuario y la contraseña
    String user = "admin";
    String password = "admin";

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


//Recuperamos los elementos de la vista
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextPswrd = findViewById(R.id.editTextPswrd);
        Button btnLogIn = findViewById(R.id.btnLogIn);
        Button btnModificarDatos = findViewById(R.id.btnModificarDatos);

//OnClickListener para añadir al función al boton de Inicio de sesión
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextName.getText().toString().equals(user) && editTextPswrd.getText().toString().equals(password)){
                    Intent iniciarSesion = new Intent(LogIn.this, LogInCorrect.class);
                    iniciarSesion.putExtra("NombreUsuario", editTextName.getText().toString());
                    startActivity(iniciarSesion);
                }else {
               //se crea  un toast par indicar q los campos son incorrectos
                    Toast.makeText(LogIn.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });
//ActivityResultLauncher para la modificación de datos de la actividad de modificar datos q finaliza
        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent intent = result.getData();
                    if (intent != null) {
                        user = intent.getStringExtra("user");
                         password = intent.getStringExtra("password");
                    //Se crea un toast para indicar que se han actualizado los datos
                        Toast.makeText(LogIn.this, "Datos Actualizados Correctamente", Toast.LENGTH_SHORT).show();

                    }
                }
            });

//OnClickListener para que el boton modificar datos nos rediriga a la actividad correspondiente
        btnModificarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent modificarDatos = new Intent(LogIn.this, ModifiacarDatos.class);
                modificarDatos.putExtra("user", user);
                modificarDatos.putExtra("password", password);
                activityResultLauncher.launch(modificarDatos);
            }
        });

    }
}
package com.example.pmddmm_eval1_javier_rodriguez_montero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FormularioReservaActivity extends AppCompatActivity {

    private Spinner spinner1;
    // private EditText etNombre, etApellidos, etTelefono, etEmail, etCajaComentario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_reserva);

        // Toast.makeText(this, "Metodo OnCreate del FormularioReservaActivity", Toast.LENGTH_LONG).show();

        /*
        DE MOMENTO NO SON NECESARIOS
        etNombre = (EditText)findViewById(R.id.etNombre);
        etApellidos = (EditText)findViewById(R.id.etApellidos);
        etTelefono = (EditText)findViewById(R.id.etTelefono);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etCajaComentario = (EditText)findViewById(R.id.etCajaComentarios);
         */
        spinner1 = (Spinner)findViewById(R.id.spinnerModalidad);

        String[] opciones = {"presencial", "online"};

        ArrayAdapter <String> arrAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item_opciones, opciones); // COMUNICACION DEL ARRAY CON EL SPINNER
        spinner1.setAdapter(arrAdapter);
    }

    public void confirmar(View view) {
        Toast.makeText(this, "Reserva realizada con éxito!", Toast.LENGTH_LONG).show();
    }
 /*
    public boolean esTelefonoValido(String telefono) {
        return Patterns.PHONE.matcher(telefono).matches();
    }

    public boolean esCorreoValido(String correo) {
        return Patterns.EMAIL_ADDRESS.matcher(correo).matches();
    }
 */
}

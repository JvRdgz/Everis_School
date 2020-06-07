package com.example.pmddmm_p4_javier_rodriguez_montero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RegistrarActivity extends AppCompatActivity {

    private EditText etNombreUsuarioRegistrar,  etContrasenaUsuarioRegistrar, etContrasenaUsuarioRepRegistrar;
    private static final String MIFICHERO = "FicheroUsuariosRegistrados.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        etNombreUsuarioRegistrar = (EditText)findViewById(R.id.ediTextRegistrarNombreUsuario);
        etContrasenaUsuarioRegistrar = (EditText)findViewById(R.id.ediTextRegistrarseContrasenaUsuario);
        etContrasenaUsuarioRepRegistrar = (EditText)findViewById(R.id.ediTextRegistrarseContrasenaUsuarioRep);
    }

    public void registrar(View view) {
        String valorEtNombreUsuarioRegistrar = etNombreUsuarioRegistrar.getText().toString();
        String valorEtContrasenaRegistrar = etContrasenaUsuarioRegistrar.getText().toString();
        String valorEtContrasenaRep = etContrasenaUsuarioRepRegistrar.getText().toString();

        if (!valorEtContrasenaRegistrar.equals(valorEtContrasenaRep)) {
            etContrasenaUsuarioRegistrar.setText("");
            etContrasenaUsuarioRepRegistrar.setText("");
            Toast.makeText(this, "Error, las contraseñas no coinciden.", Toast.LENGTH_SHORT).show();
        } else {
            Usuario usuario = new Usuario(valorEtNombreUsuarioRegistrar, valorEtContrasenaRegistrar);
            try {
                if (comprobarUsuario(usuario))
                    Toast.makeText(this, "Ya existe una cuenta con ese nombre de usuario.", Toast.LENGTH_SHORT).show();
                else {
                    OutputStreamWriter osw = new OutputStreamWriter(openFileOutput(MIFICHERO, Activity.MODE_APPEND));
                    osw.write(usuario.toString() + "\n");
                    osw.close();
                    Toast.makeText(this, "Registrado con éxito", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, MainActivity.class));
                }
            } catch (IOException e) {
                Toast.makeText(this, "No se pudo grabar", Toast.LENGTH_SHORT).show();
                Log.e("Exception", "File write failed: " + e.toString());
            }
        }
    }

    // SI DEVUELVE TRUE, ES QUE EL USUARIO YA ESTA REGISTRADO CON ESE NOMBRE.
    public boolean comprobarUsuario(Usuario s) {
        boolean encontrado = false;
        Usuario sc;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput(MIFICHERO)));
            String linea = br.readLine();
            while (linea != null) {
                String[] s_parts = linea.split("#");
                sc = new Usuario(s_parts[0], s_parts[1]);
                if (sc.getNombreUsuario().equalsIgnoreCase(s.getNombreUsuario())) {
                    encontrado = true;
                    break;
                }
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            // Toast.makeText(this, "Error leyendo el fichero: " + MIFICHERO, Toast.LENGTH_LONG).show();
        }
        return encontrado;
    }
}

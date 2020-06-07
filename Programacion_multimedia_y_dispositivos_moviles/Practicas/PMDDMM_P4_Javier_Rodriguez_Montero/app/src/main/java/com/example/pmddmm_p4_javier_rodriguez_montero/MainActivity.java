package com.example.pmddmm_p4_javier_rodriguez_montero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText etNombreUsuarioLogIn,  etContrasenaUsuarioLogIn;
    private static final String MIFICHERO = "FicheroUsuariosRegistrados.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombreUsuarioLogIn = (EditText)findViewById(R.id.ediTextLogInNombreUsuario);
        etContrasenaUsuarioLogIn = (EditText)findViewById(R.id.ediTextLogInContrasenaUsuario);
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        // SharedPreferences preferencias = getPreferences(Context.MODE_PRIVATE);
        String nombreUsuario = preferencias.getString("nombre", "");
        etNombreUsuarioLogIn.setText(nombreUsuario);
    }

    public void login(View view) {
        String valorEtNombreUsuarioLogIn = etNombreUsuarioLogIn.getText().toString();
        String valorEtContrasenaLogIn = etContrasenaUsuarioLogIn.getText().toString();
        if (valorEtContrasenaLogIn.isEmpty() || valorEtNombreUsuarioLogIn.isEmpty()) {
            Toast.makeText(this, "No puede haber campos vacíos.", Toast.LENGTH_LONG).show();
        } else {
            Usuario usuario = new Usuario(valorEtNombreUsuarioLogIn, valorEtContrasenaLogIn);

            if (comprobarUsuario(usuario)) {
                if (comprobarContrasena(usuario)) {
                    SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putString("nombre", etNombreUsuarioLogIn.getText().toString());
                    // editor.putInt("edad", 3);
                    // editor.putBoolean("activo", true);
                    // editor.putFloat("altura", 2.3f);
                    editor.commit();
                    startActivity(new Intent(this, BienvenidaActivity.class));
                } else {
                    Toast.makeText(this, "Contraseña incorrecta.", Toast.LENGTH_LONG).show();
                    etContrasenaUsuarioLogIn.setText("");
                }
            } else {
                startActivity(new Intent(this, RegistrarActivity.class));
            }
        }
    }

    public boolean comprobarContrasena(Usuario s) {
        boolean contrasena = false;
        Usuario sc;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput(MIFICHERO)));
            String linea = br.readLine();
            while (linea != null) {
                String[] s_parts = linea.split("#");
                sc = new Usuario(s_parts[0], s_parts[1]);
                if (sc.getContrasena().equals(s.getContrasena())) {
                    contrasena = true;
                    break;
                }
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            Toast.makeText(this, "Error al comprobar contraseña", Toast.LENGTH_LONG).show();
        }
        return contrasena;
    }

    public void registrarse(View view) {
        startActivity(new Intent(this, RegistrarActivity.class));
    }

    // SI DEVUELVE TRUE, EL USUARIO ESTA REGISTRADO
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
            Toast.makeText(this, "No existe el usuario", Toast.LENGTH_LONG).show();
        }
        return encontrado;
    }

    /*
    public boolean comprobarFichero() {
        boolean existe = false;
        String[] archivos = fileList();
        for (int f = 0; f < archivos.length; f++) {
            if (MIFICHERO.equals(archivos[f])) {
                existe = true;
                break;
            }
        }
        return existe;
    }

     */
}
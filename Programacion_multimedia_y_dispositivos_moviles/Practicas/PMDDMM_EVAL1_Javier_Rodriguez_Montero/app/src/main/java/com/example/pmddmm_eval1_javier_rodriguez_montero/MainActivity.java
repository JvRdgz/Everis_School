package com.example.pmddmm_eval1_javier_rodriguez_montero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Metodo Oncreate del MainActivity", Toast.LENGTH_LONG).show();
    }

    // METODO PARA MOSTRAR Y OCULTAR EL MENU
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        Toast.makeText(this, "Metodo OncreateOptionsMenu del MainActivity", Toast.LENGTH_LONG).show();
        return true;
    }

    // METODO PARA ASIGNAR FUNCIONES CORRESPONDIENTES A LAS OPCIONES
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId(); // ITEM SELECCIONADO

        if (id == R.id.item1) {
            Toast.makeText(this, getString(R.string.item1), Toast.LENGTH_SHORT).show();
            // Toast.makeText(this, "Abriendo formulario de reserva", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, FormularioReservaActivity.class));
        }

        if (id == R.id.item2) {
            Toast.makeText(this, getString(R.string.item2), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Abriendo Pagina web", Toast.LENGTH_LONG).show();
            // startActivity(new Intent(this, WebView.class));
        }

        if (id == R.id.item3) {
            Toast.makeText(this, getString(R.string.item3), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Abriendo Mapa", Toast.LENGTH_LONG).show();
            // startActivity(new Intent(this, Mapa.class));
        }

        return super.onOptionsItemSelected(item);
    }
}

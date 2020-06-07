package com.example.pmddmm_p3_javier_rodriguez_montero;

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
    }

    // MENU PARA MOSTRAR Y OCULTAR EL MENU
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // METODO PARA ASIGNAR LAS FUNCIONES CORRESPONDIENTES A LAS OPCIONES
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item1) {
            Toast.makeText(this, "Abriendo Enesimo numero primo", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivityEnesimo.class));
        }

        if (id == R.id.item2) {
            Toast.makeText(this, "Abriendo Dia y Noche", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivityDiaNoche.class));
        }

        if (id == R.id.item3) {
            Toast.makeText(this, "Abriendo Conversor", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivityConversor.class));
        }

        if (id == R.id.item4) {
            Toast.makeText(this, "Abriendo Web View", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivityWebView.class));
        }

        return super.onOptionsItemSelected(item);
    }
}

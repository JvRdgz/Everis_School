package com.example.pmddmm_p3_javier_rodriguez_montero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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

        if (id == R.id.item5) {
            Toast.makeText(this, "Abriendo mapa", Toast.LENGTH_LONG).show();
            startActivity(new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com/maps/place/Everis+School+Valladolid/@41.6269183,-4.7264971,15z/data=!4m8!1m2!2m1!1sEducaci%C3%B3n+mixta!3m4!1s0xd4712d778d58871:0xe0eff4d43629974e!8m2!3d41.6268986!4d-4.7177423")));
        }

        return super.onOptionsItemSelected(item);
    }
}

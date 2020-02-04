package com.example.pmddmm_eval1_javier_rodriguez_montero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Desarrollada por Javier Rodriguez", Toast.LENGTH_LONG).show();


    }

    // METODO PARA PODER MOSTRAR Y OCULTAR EL MENU
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opciones, menu);
        return true;
    }

    // METODO PARA ASIGNAR LAS FUNCIONES CORRESPONDIENTES A LAS OPCIONES

    //public boolean onOptionsItemSelected(MenuItem item) {
      //  int id = item.getItemId();

        /*if (id == R.id.item1) {

        }*/
    //}
}

package com.example.pmddmm_p1_javier_rodriguez_montero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Ejecutando metodo OnCreate", Toast.LENGTH_LONG).show();
        Log.i("Ciclo de vida", "OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Ejecutando metodo onStart", Toast.LENGTH_LONG).show();
        Log.i("Ciclo de vida", "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Ejecutando metodo onResume", Toast.LENGTH_LONG).show();
        Log.i("Ciclo de vida", "OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Ejecutando metodo onPause", Toast.LENGTH_LONG).show();
        Log.i("Ciclo de vida", "OnPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Ejecutando metodo onRestart", Toast.LENGTH_LONG).show();
        Log.i("Ciclo de vida", "OnRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Ejecutando metodo onStop", Toast.LENGTH_LONG).show();
        Log.i("Ciclo de vida", "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Ejecutando metodo onDestroy", Toast.LENGTH_LONG).show();
        Log.i("Ciclo de vida", "OnDestroy");
    }
}

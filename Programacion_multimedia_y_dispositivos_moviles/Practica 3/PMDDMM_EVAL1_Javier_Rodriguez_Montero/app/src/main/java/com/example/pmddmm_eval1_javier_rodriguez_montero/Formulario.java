package com.example.pmddmm_eval1_javier_rodriguez_montero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Formulario extends AppCompatActivity {

    private Spinner spinner_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        spinner_1 = (Spinner)findViewById(R.id.spinner_1);

        String [] operaciones_spinner = {"Presencial", "Online"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, operaciones_spinner);
        spinner_1.setAdapter(adapter);
    }
}

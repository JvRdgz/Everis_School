package com.example.pmddmm_p2_javier_rodriguez_montero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edit_Text_1, edit_Text_2;
    private TextView text_View_1;
    private Spinner spinner_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Desarrollada por Javier Rodriguez", Toast.LENGTH_LONG).show();
        edit_Text_1 = (EditText)findViewById(R.id.edit_Text_1);
        edit_Text_2 = (EditText)findViewById(R.id.edit_Text_2);
        text_View_1 = (TextView)findViewById(R.id.text_View_1);
        spinner_1 = (Spinner)findViewById(R.id.spinner_1);

        String [] operaciones_spinner = {"sumar", "restar", "multiplicar", "dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, operaciones_spinner);
        spinner_1.setAdapter(adapter);
    }

    public void calcular(View view) {
        String valor_1_string = edit_Text_1.getText().toString();
        String valor_2_string = edit_Text_2.getText().toString();

        int valor_1_int = Integer.parseInt(valor_1_string);
        int valor_2_int = Integer.parseInt(valor_2_string);

        String selection = spinner_1.getSelectedItem().toString();

        if (selection.equals("sumar"))
            text_View_1.setText(String.valueOf(Calculadora.sumar(valor_1_int, valor_2_int)));
        else if (selection.equals("restar"))
            text_View_1.setText(String.valueOf(Calculadora.restar(valor_1_int, valor_2_int)));
        else if (selection.equals("multiplicar"))
            text_View_1.setText(String.valueOf(Calculadora.multiplicar(valor_1_int, valor_2_int)));
        else if (selection.equals("dividir")) {
            if (valor_2_int == 0)
                Toast.makeText(this, "Error, el divisor no puede ser 0", Toast.LENGTH_LONG).show();
            else
                text_View_1.setText(String.valueOf(Calculadora.dividir(valor_1_int, valor_2_int)));
        }
    }
}

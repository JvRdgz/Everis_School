package com.example.pmddmm_p3_javier_rodriguez_montero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityEnesimo extends AppCompatActivity {

    private EditText txt1; // Para introducir valores.
    private TextView txt_v1; // Para mostrar el resultado.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_enesimo);
        Toast.makeText(this, "Hola :)", Toast.LENGTH_LONG).show();

        txt1 = (EditText)findViewById(R.id.txt_1);
        txt_v1 = (TextView)findViewById(R.id.txt_2);
    }

    public void enesimo_primo(View view) {
        String valor_txt1 = txt1.getText().toString();

        int num = Integer.parseInt(valor_txt1);
        if (num > 999999) {
            Toast.makeText(this, "El valor introducido es demasiado grande. Tiene que tener menos de siete cifras", Toast.LENGTH_LONG).show();
            num = Integer.parseInt(valor_txt1);
        } else {
            String result = String.valueOf(CalculoEnesimoPrimo.calculoEnesimo(num));
            txt_v1.setText(result);
        }
    }
}

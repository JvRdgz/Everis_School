package com.example.pmddmm_p3_javier_rodriguez_montero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityConversor extends AppCompatActivity {

    private EditText edit_txt1;
    private TextView txt_V1;
    private RadioButton radioButtonHex1, radioButtonBi2, radioButtonDe3, radioButtonHex4, radioButtonBi5, radioButtonDe6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_conversor);

        Toast.makeText(this, "Desarrollada por Javier Rodriguez", Toast.LENGTH_LONG).show();

        edit_txt1 = (EditText)findViewById(R.id.editText1);
        txt_V1 = (TextView)findViewById(R.id.textV1);
        radioButtonHex1 = (RadioButton)findViewById(R.id.radioButtonH1);
        radioButtonBi2 = (RadioButton)findViewById(R.id.radioButtonB2);
        radioButtonDe3 = (RadioButton)findViewById(R.id.radioButtonD3);
        radioButtonHex4 = (RadioButton)findViewById(R.id.radioButtonH4);
        radioButtonBi5 = (RadioButton)findViewById(R.id.radioButtonB5);
        radioButtonDe6 = (RadioButton)findViewById(R.id.radioButtonD6);
    }

    public void conversor(View view) {
        String valor_edit_txt1 = edit_txt1.getText().toString();

        if (radioButtonHex1.isChecked() && radioButtonBi5.isChecked())
            txt_V1.setText(Conversor.hexadecimal_a_binario(valor_edit_txt1));
        else if (radioButtonHex1.isChecked() && radioButtonDe6.isChecked())
            txt_V1.setText(Conversor.hexadecimal_a_decimal(valor_edit_txt1));
        else if (radioButtonBi2.isChecked() && radioButtonHex4.isChecked())
            txt_V1.setText(Conversor.bianario_a_hexadecimal(valor_edit_txt1));
        else if (radioButtonBi2.isChecked() && radioButtonDe6.isChecked())
            txt_V1.setText(Conversor.binario_a_decimal(valor_edit_txt1));
        else if (radioButtonDe3.isChecked() && radioButtonHex4.isChecked())
            txt_V1.setText(Conversor.decimal_a_hexadecimal(valor_edit_txt1));
        else if (radioButtonDe3.isChecked() && radioButtonBi5.isChecked())
            txt_V1.setText(Conversor.decimal_a_binario(valor_edit_txt1));
        else
            Toast.makeText(this, "Error, no has introducido ningun valor.", Toast.LENGTH_LONG).show();
    }

}

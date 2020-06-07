package com.example.pmddmm_p3_javier_rodriguez_montero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivityDiaNoche extends AppCompatActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dia_noche);

        txt = (TextView)findViewById(R.id.txt);
    }

    public void sun(View view) {
        txt.setText("Es de día!");
    }

    public void moon(View view) {
        txt.setText("Es de noche!");
    }
}

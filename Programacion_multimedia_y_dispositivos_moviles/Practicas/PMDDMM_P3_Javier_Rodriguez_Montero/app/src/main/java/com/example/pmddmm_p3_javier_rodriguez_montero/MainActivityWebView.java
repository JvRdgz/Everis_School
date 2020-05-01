package com.example.pmddmm_p3_javier_rodriguez_montero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivityWebView extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_web_view_app);

        et1 = (EditText)findViewById(R.id.editText_WebView);

        // Inicializamos a un WebView
        // WebView simpleWebView=(WebView) findViewById(R.id.simpleWebView);


        /**
         * SI QUISIERAMOS UN HTML PERSONALIZADO
         * static html string data
         * String customHtml = "<html><body><h1>Hola DAM</h1>" +
         * "<h1>Título 1</h1><h2>Título 2</h2><h3>Título 3</h3>" +
         * "<p>Ejemplo de un párrafo en HTML estático. </p>" +
         * "</body></html>";
         * load static html data on a web view
         * webView.loadData(customHtml, "text/html", "UTF-8");
         */


        // Especificamos la URL del sitio web en el loadUrl
        // simpleWebView.loadUrl("https://www.ecoriding.es/");
    }

    // METODO BOTON BUSCAR
    public void navegar(View view) {
        Intent i = new Intent(this, ActivityWeb.class);
        i.putExtra("sitioWeb", et1.getText().toString());
        startActivity(i);
    }
}

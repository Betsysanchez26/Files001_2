package com.example.betsysanchez.files001_2;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Button guardar,cargar;
    EditText texto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto=findViewById(R.id.EditText);
        guardar=findViewById(R.id.guardar);
        cargar=findViewById(R.id.cargar);
    }

    public void cargar(View view) {
        try {
            File ruta = Environment.getExternalStorageDirectory();
            File archivo = new File(ruta.getAbsolutePath(), "archivo.txt");
            BufferedReader leerArchivo = new BufferedReader(new InputStreamReader(new FileInputStream(archivo)));
            String cad = leerArchivo.readLine();
            texto.setText(cad);
            leerArchivo.close();
            Toast.makeText(getBaseContext(), "Archivo cargado", Toast.LENGTH_SHORT).show();
        }
        catch (Exception ex) {
        }
    }

    public void guardar(View view) {
        String cad = this.texto.getText().toString();
        try {
            File ruta = Environment.getExternalStorageDirectory();
            File archivo = new File(ruta.getAbsolutePath(), "archivo.txt");
            OutputStreamWriter escribirArchivo = new OutputStreamWriter(new FileOutputStream(archivo));
            escribirArchivo.write(cad);
            escribirArchivo.close();
            Toast.makeText(getBaseContext(), "Se creo el archivo", Toast.LENGTH_SHORT).show();
        }
        catch (Exception ex) {
        }
    }
}

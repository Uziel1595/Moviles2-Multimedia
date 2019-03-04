package com.example.iowner.a12multimedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Principal extends AppCompatActivity {

    Archivo[] archivos = { new Archivo("Musica","Cotton fields","Credeence",R.raw.cottonfields),
            new Archivo("Musica","Come on feel the noise","Credeence",R.raw.comeonfeel),
            new Archivo("Musica","One","Apocalyptica",R.raw.cne),
            new Archivo("Video","Symphony 40","Metallica",R.raw.symphony)
    };
    private EditText editTxtGuardar;
    private Button btnBuscar;
    private ListView listViewArchivos;

    Intent iArchivo,iVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        editTxtGuardar = findViewById(R.id.editTxtBuscar);
        btnBuscar = findViewById(R.id.btnBuscar);
        listViewArchivos = findViewById(R.id.listViewArchivos);

        listViewArchivos.setAdapter(new MultimediaAdapter(this,R.layout.archivo,archivos));

        iArchivo = new Intent(this,ReproduccionArchivo.class);

        iVideo = new Intent(this,ReproducirVideo.class);

        listViewArchivos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(archivos[i].getTipo().equals("Musica")){
                    iArchivo.putExtra("tipo",archivos[i].getTipo());
                    iArchivo.putExtra("nombre",archivos[i].getNombre());
                    iArchivo.putExtra("artista",archivos[i].getArtista());
                    iArchivo.putExtra("id",archivos[i].getId());
                    startActivity(iArchivo);
                }else{
                    iVideo.putExtra("id",archivos[i].getId());
                    startActivity(iVideo);
                }
            }
        });


    }
}

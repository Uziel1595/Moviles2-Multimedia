package com.example.iowner.a12multimedia;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by iOwner on 01/03/2019.
 */

class MultimediaAdapter extends ArrayAdapter<Archivo> {
    Context cContexto;
    int iLayout;
    Archivo[] archivos;
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView txtTipo, txtNombre, txtArtista;

        View vFila = convertView;
        if(vFila == null){//no existe fila creeamos
            //PARA CREAR LA VISTA USAMOS LAYOUTINFLATER
            LayoutInflater liVista = ((Activity)cContexto).getLayoutInflater();
            vFila = liVista.inflate(iLayout,parent,false);

        }
        //VINCULAR WIDGETS
        txtTipo = vFila.findViewById(R.id.txtTipo);
        txtNombre = vFila.findViewById(R.id.txtNombre);
        txtArtista = vFila.findViewById(R.id.txtArtista);

        Archivo aActual = archivos[position];

        txtTipo.setText(aActual.getTipo());
        txtNombre.setText(aActual.getNombre());
        txtArtista.setText(aActual.getArtista());
        return vFila;
    }

    public MultimediaAdapter(@NonNull Context context, int resource, @NonNull Archivo[] objects) {
        super(context, resource, objects);
        cContexto = context;
        iLayout = resource;
        archivos = objects;
    }

}

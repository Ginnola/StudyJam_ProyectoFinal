package com.example.telassimgomez.studyjam_proyectofinal;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapterP extends BaseAdapter {

    private Context context;
    private ArrayList<Colores> items;

    public CustomAdapterP(Activity activity, ArrayList data) {
        this.context = activity;
        this.items = data;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomAdapterP.ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista_puntos, parent, false);
            viewHolder = new CustomAdapterP.ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CustomAdapterP.ViewHolder) convertView.getTag();
        }

//        Typeface tf_thin = Typeface.createFromAsset(
//                context.getAssets(), "fonts/roboto_thin.ttf");

//        viewHolder.itemNombre.setTypeface(tf_thin);
//        viewHolder.itemTipo.setTypeface(tf_thin);

        PuntosR currentItem = (PuntosR) getItem(position);
        viewHolder.itemNombre.setText(currentItem.getNombre());
        viewHolder.itemImagen.setImageResource(currentItem.getImagenP());

        return convertView;
    }

    private class ViewHolder {
        TextView itemNombre;
        ImageView itemImagen;

        public ViewHolder(View view) {
            itemNombre = (TextView)view.findViewById(R.id.tvTituloP);
            itemImagen = (ImageView) view.findViewById(R.id.ivImagenP);
        }
    }

}

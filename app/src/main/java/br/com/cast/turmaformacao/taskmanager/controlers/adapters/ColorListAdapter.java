package br.com.cast.turmaformacao.taskmanager.controlers.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.cast.turmaformacao.taskmanager.R;
import br.com.cast.turmaformacao.taskmanager.model.entidade.Color;

/**
 * Created by Administrador on 17/09/2015.
 */
public class ColorListAdapter extends BaseAdapter {

     private Activity context;
     private Color[] colors;


    public ColorListAdapter(Activity context, Color[] colors){
        this.context = context;
        this.colors = colors;
    }


    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Color getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Color color = getItem(position);

        View colorView = context.getLayoutInflater().inflate(R.layout.list_item_color, parent, false);
        int cor;
        cor = android.graphics.Color.parseColor(color.getHex());

        colorView.findViewById(R.id.viewColor);
        colorView.setBackgroundColor(cor);
        return colorView;
    }
}

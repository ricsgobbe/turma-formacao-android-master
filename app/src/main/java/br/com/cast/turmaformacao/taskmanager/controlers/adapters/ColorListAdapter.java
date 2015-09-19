package br.com.cast.turmaformacao.taskmanager.controlers.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import br.com.cast.turmaformacao.taskmanager.model.entidade.Color;

/**
 * Created by Administrador on 17/09/2015.
 */
public class ColorListAdapter extends BaseAdapter {

     private Activity context;
     private List<Color> colors;


    public ColorListAdapter(Activity context, List<Color> colors){
        this.context = context;
        this.colors = colors;
    }


    @Override
    public int getCount() {
        return colors.size();
    }

    @Override
    public Color getItem(int position) {
        return colors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}

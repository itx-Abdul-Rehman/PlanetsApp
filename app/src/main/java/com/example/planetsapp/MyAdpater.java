package com.example.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdpater extends ArrayAdapter<Planet> {
   private Context context;
   private ArrayList<Planet> planetArrayList=new ArrayList<>();

    public MyAdpater( Context context, ArrayList<Planet> planetArrayList) {
        super(context, R.layout.my_list_layout,planetArrayList);
        this.context = context;
        this.planetArrayList = planetArrayList;
    }




    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.my_list_layout,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.planetName=convertView.findViewById(R.id.planetName);
            viewHolder.planetImage=convertView.findViewById(R.id.planetImage);
            viewHolder.moons=convertView.findViewById(R.id.moons);
            convertView.setTag(viewHolder);

        }else{
            viewHolder=(ViewHolder) convertView.getTag();
        }

        viewHolder.planetImage.setImageResource(planetArrayList.get(position).getPlanetImage());
        viewHolder.planetName.setText(planetArrayList.get(position).getPlanetName());
        viewHolder.moons.setText(planetArrayList.get(position).getMoons());


        return convertView;
    }

    static class ViewHolder{
        TextView planetName;
        TextView moons;
        ImageView planetImage;

    }
}

package com.example.planetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);

        ArrayList<Planet> planets=new ArrayList<>();

        Planet planet=new Planet("Jupiter","12 Moons",R.drawable.jupiter);
        Planet planet2=new Planet("Mars","0 Moons",R.drawable.mars);
        Planet planet3=new Planet("Mercury","0 Moons",R.drawable.mercury);
        Planet planet4=new Planet("Neptune","2 Moons",R.drawable.neptune);
        Planet planet5=new Planet("Pluto","8 Moons",R.drawable.pluto);
        Planet planet6=new Planet("Saturn","22 Moons",R.drawable.saturn);
        Planet planet7=new Planet("Uranus","14 Moons",R.drawable.uranus);
        Planet planet8=new Planet("Venus","10 Moons",R.drawable.venus);
        Planet planet9=new Planet("Earth","1 Moons",R.drawable.earth);
        planets.add(planet9);
        planets.add(planet);
        planets.add(planet2);
        planets.add(planet3);
        planets.add(planet4);
        planets.add(planet5);
        planets.add(planet6);
        planets.add(planet7);
        planets.add(planet8);

        MyAdpater myAdpater=new MyAdpater(this,planets);
        listView.setAdapter(myAdpater);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Clicked "+planets.get(position).getPlanetName(),Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
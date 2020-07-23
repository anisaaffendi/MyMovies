package sg.edu.rp.c346.id19030019.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movies> MovieList = new ArrayList<Movies>();
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.listViewMovies);

        Calendar cal = Calendar.getInstance();
        String strDescription = "";


        strDescription = "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.";
        cal.set(2014, 11, 15);
        Movies m1 = new Movies("The Avengers", 2012, "pg13", "Action | Sci-Fi", cal, "Golden Village - Bishan", strDescription);
        MovieList.add(m1);

        strDescription = "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.";
        cal.set(2015, 5, 15);
        Movies m2 = new Movies("Planes", 2013, "pg", "Animation | Comedy", cal, "Cathay - AMK Hub", strDescription);
        MovieList.add(m2);

        adapter = new CustomAdapter(this, R.layout.row, MovieList);
        lvMovie.setAdapter(adapter);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MovieDetailsActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST", (Serializable)MovieList);
                intent.putExtra("MovieList", args);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}
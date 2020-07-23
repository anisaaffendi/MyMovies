package sg.edu.rp.c346.id19030019.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieDetailsActivity extends AppCompatActivity {
    ArrayList<Movies> movieList = new ArrayList<Movies>();
    ImageView ivRating;
    TextView tvTitle, tvCategory, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("MovieList");
        movieList = (ArrayList<Movies>) args.getSerializable("ARRAYLIST");
        int position = intent.getIntExtra("position", 0);
        Movies currentItem = movieList.get(position);

        ivRating = findViewById(R.id.imageViewRate);
        tvTitle = findViewById(R.id.textViewTitle1);
        tvCategory = findViewById(R.id.textViewCategory1);
        tvDescription = findViewById(R.id.textViewDescription1);

        if (currentItem.getRated().equals("g")) {
            ivRating.setImageResource(R.drawable.rating_g);
        } else if (currentItem.getRated().equals("pg")) {
            ivRating.setImageResource(R.drawable.rating_pg);
        } else if (currentItem.getRated().equals("pg13")) {
            ivRating.setImageResource(R.drawable.rating_pg13);
        } else if (currentItem.getRated().equals("nc16")) {
            ivRating.setImageResource(R.drawable.rating_nc16);
        } else if (currentItem.getRated().equals("m18")) {
            ivRating.setImageResource(R.drawable.rating_m18);
        } else if (currentItem.getRated().equals("r21")) {
            ivRating.setImageResource(R.drawable.rating_r21);
        }

        tvTitle.setText(currentItem.getTitle());
        String strCategory = (currentItem.getYear()) + " - " + currentItem.getGenre();
        tvCategory.setText(strCategory);
        tvDescription.setText(currentItem.getDescription());
    }
}
package sg.edu.rp.c346.id19030019.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movies> contactList;

    public CustomAdapter(Context context, int resources, ArrayList<Movies> objects) {
        super(context, resources, objects);
        this.parent_context = context;
        this.layout_id = resources;
        this.contactList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        ImageView ivRating = rowView.findViewById(R.id.imageViewRating);
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvCategory = rowView.findViewById(R.id.textViewCategory);

        Movies currentItem = contactList.get(position);
        tvTitle.setText(currentItem.getTitle());
        String strCategory = (currentItem.getYear()) + " - " + currentItem.getGenre();
        tvCategory.setText(strCategory);


        if (currentItem.getRated() == "PG13" || currentItem.getRated() == "pg13"){
            ivRating.setImageResource(R.drawable.rating_pg13);
        } else if (currentItem.getRated() == "PG" || currentItem.getRated() == "pg"){
            ivRating.setImageResource(R.drawable.rating_pg);
        } else if(currentItem.getRated() == "m18" || currentItem.getRated() == "M18"){
            ivRating.setImageResource(R.drawable.rating_m18);
        } else if(currentItem.getRated() == "nc16" || currentItem.getRated() == "NC16"){
            ivRating.setImageResource(R.drawable.rating_nc16);
        }else if(currentItem.getRated() == "r21" || currentItem.getRated() == "R21"){
            ivRating.setImageResource(R.drawable.rating_r21);
        }else if(currentItem.getRated() == "g" || currentItem.getRated() == "G"){
            ivRating.setImageResource(R.drawable.rating_g);
        }

        return rowView;
    }
}

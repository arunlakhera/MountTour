package com.pikchillytechnologies.mounttour;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FavouriteAdapter extends ArrayAdapter<Places> {

    private LayoutInflater placesInflter;
    private Places place;

    public FavouriteAdapter(Context context, List<Places> placeList) {
        super(context, 0, placeList);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = placesInflter.from(getContext()).inflate(R.layout.listview_favourite, parent, false);
        }

        place = getItem(position);

        ImageView placeImageView = convertView.findViewById(R.id.imageView_Place);
        TextView placeName_TextView = convertView.findViewById(R.id.textView_PlaceName);
        TextView cityStateName_TextView = convertView.findViewById(R.id.textView_CityStateName);

        String city_State = String.valueOf(place.getM_CityName()) + ", " + String.valueOf(place.getM_StateName());

        placeImageView.setImageResource(place.getM_PlaceImageId());
        placeName_TextView.setText(String.valueOf(place.getM_PlaceName()));
        cityStateName_TextView.setText(city_State);

        return convertView;
    }
}
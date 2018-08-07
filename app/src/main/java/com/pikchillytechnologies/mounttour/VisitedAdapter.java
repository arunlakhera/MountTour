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

public class VisitedAdapter extends ArrayAdapter<Events> {

    private LayoutInflater visitedInflter;
    private Events event;

    public VisitedAdapter(Context context, List<Events> eventList) {
        super(context, 0, eventList);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = visitedInflter.from(getContext()).inflate(R.layout.listview_visited, parent, false);
        }

        event = getItem(position);

        ImageView placeImageView = convertView.findViewById(R.id.imageView_PlaceImage);
        TextView placeName_TextView = convertView.findViewById(R.id.textView_PlaceName);

        placeImageView.setImageResource(event.getM_PlaceImageId());
        placeName_TextView.setText(String.valueOf(event.getM_PlaceName()));

        return convertView;
    }
}
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

public class EventsAdapter extends ArrayAdapter<Events> {

    private LayoutInflater eventsInflter;
    private Events event;

    public EventsAdapter(Context context, List<Events> eventList) {
        super(context, 0, eventList);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = eventsInflter.from(getContext()).inflate(R.layout.listview_events, parent, false);
        }

        event = getItem(position);

        ImageView placeImageView = convertView.findViewById(R.id.imageView_PlaceImage);
        TextView eventDate_TextView = convertView.findViewById(R.id.textView_EventDate);
        TextView placeName_TextView = convertView.findViewById(R.id.textView_PlaceName);
        TextView duration_TextView = convertView.findViewById(R.id.textView_Duration);
        TextView cost_TextView = convertView.findViewById(R.id.textView_Cost);
        TextView phone_TextView = convertView.findViewById(R.id.textView_Phone);

        placeImageView.setImageResource(event.getM_PlaceImageId());
        eventDate_TextView.setText(String.valueOf(event.getM_EventDate()));
        placeName_TextView.setText(String.valueOf(event.getM_PlaceName()));
        duration_TextView.setText(String.valueOf(event.getM_Duration()));
        cost_TextView.setText(String.valueOf(event.getM_Cost()));
        phone_TextView.setText(String.valueOf(event.getM_Phone()));

        return convertView;
    }
}
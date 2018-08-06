package com.pikchillytechnologies.mounttour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Variable Declarations
        TextView m_Title_TextView;
        Button m_Button_Destinations;
        Button m_Button_Favourite;
        Button m_Button_Events;
        Button m_Button_Back;

        //Initialize Variables
        m_Title_TextView = findViewById(R.id.textView_Title);
        m_Button_Destinations = findViewById(R.id.button_Destinations);
        m_Button_Favourite = findViewById(R.id.button_Favourite);
        m_Button_Events = findViewById(R.id.button_Events);
        m_Button_Back = findViewById(R.id.button_Back);

        // Make Back button invisible for home screen
        m_Button_Back.setVisibility(View.INVISIBLE);

        // Set the title of Activity
        m_Title_TextView.setText(R.string.app_home);

        // Action to perform when Destinations button is clicked
        m_Button_Destinations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeIntent("DestinationsActivity");
            }
        });

        // Action to perform when Favourite button is clicked
        m_Button_Favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeIntent("FavouriteActivity");
            }
        });

        // Action to perform when Events button is clicked
        m_Button_Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeIntent("EventsActivity");
            }
        });
    }

    /**
     * Function to perform action when homeIntent is called by pressing Destination / Favourite / Events Activity
     */
    public void homeIntent(String destination) {

        Intent homeIntent;

        if (destination.equals("DestinationsActivity")) {
            homeIntent = new Intent(HomeActivity.this, DestinationsActivity.class);
        } else if (destination.equals("FavouriteActivity")) {
            homeIntent = new Intent(HomeActivity.this, FavouriteActivity.class);
        } else if (destination.equals("EventsActivity")) {
            homeIntent = new Intent(HomeActivity.this, EventsActivity.class);
        } else {
            homeIntent = new Intent(HomeActivity.this, HomeActivity.class);
        }
        startActivity(homeIntent);
    }
}

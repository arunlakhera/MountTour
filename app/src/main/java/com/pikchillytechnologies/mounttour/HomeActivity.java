package com.pikchillytechnologies.mounttour;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    // Variable Declarations
    TextView m_Title_TextView;
    Button m_Button_Destinations;
    Button m_Button_Favourite;
    Button m_Button_Events;
    Button m_Button_Back;
    Dialog menuDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Initialize Variables
        m_Title_TextView = findViewById(R.id.textView_Title);
        m_Button_Destinations = findViewById(R.id.button_Destinations);
        m_Button_Favourite = findViewById(R.id.button_Favourite);
        m_Button_Events = findViewById(R.id.button_Events);
        m_Button_Back = findViewById(R.id.button_Back);
        menuDialog = new Dialog(this);

        // Make Back button invisible for home screen
        m_Button_Back.setVisibility(View.INVISIBLE);

        // Set the title of Activity
        m_Title_TextView.setText(R.string.app_home);

        // Action to perform when Destinations button is clicked
        m_Button_Destinations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeIntent(String.valueOf(R.string.act_destination));
            }
        });

        // Action to perform when Favourite button is clicked
        m_Button_Favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeIntent(String.valueOf(R.string.act_favourite));
            }
        });

        // Action to perform when Events button is clicked
        m_Button_Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeIntent(String.valueOf(R.string.act_events));
            }
        });
    }

    /**
     * Function to perform action when homeIntent is called by pressing Destination / Favourite / Events Activity
     */
    public void homeIntent(String destination) {

        Intent homeIntent;

        if (destination.equals(String.valueOf(R.string.act_destination))) {
            homeIntent = new Intent(HomeActivity.this, DestinationsActivity.class);
        } else if (destination.equals(String.valueOf(R.string.act_favourite))) {
            homeIntent = new Intent(HomeActivity.this, FavouriteActivity.class);
        } else if (destination.equals(String.valueOf(R.string.act_events))) {
            homeIntent = new Intent(HomeActivity.this, EventsActivity.class);
        } else {
            homeIntent = new Intent(HomeActivity.this, HomeActivity.class);
        }
        startActivity(homeIntent);
    }

    /**
     * Menu Functions
     * */

    // 1. Function to Show Menu
    public void showMenu(View view) {

        menuDialog.setContentView(R.layout.menu_layout);
        menuDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        menuDialog.show();
    }

     // 2. Function to close Popup Menu
    public void closeMenu(View view) {
        menuDialog.dismiss();
    }

    // 3. Function for Home button
    public void menuHome(View view){
        Toast.makeText(getApplicationContext(),R.string.toast_home,Toast.LENGTH_LONG).show();
        menuDialog.dismiss();
    }

    // 4. Function for Destinations button
    public void menuDestinations(View view){
        startActivity(new Intent(HomeActivity.this,DestinationsActivity.class));
    }

    // 5. Function for Favourite button
    public void menuFavourite(View view){
        startActivity(new Intent(HomeActivity.this,FavouriteActivity.class));
    }

    // 6. Function for Event button
    public void menuEvent(View view){
        startActivity(new Intent(HomeActivity.this,EventsActivity.class));
    }
}

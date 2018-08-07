package com.pikchillytechnologies.mounttour;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EventsActivity extends AppCompatActivity {

    // Variable Declarations
    private TextView m_Title_TextView;
    private Button m_Back_Button;
    private EventsAdapter m_EventsAdapter;
    private List<Events> m_EventsList;
    Events event1;
    private ListView m_Events_ListView;
    Dialog menuDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        //Initialize Variables
        m_Title_TextView = findViewById(R.id.textView_Title);
        m_Back_Button = findViewById(R.id.button_Back);
        menuDialog = new Dialog(this);

        m_Events_ListView = findViewById(R.id.listView_Events);
        m_EventsList = new ArrayList<>();

        m_Title_TextView.setText(R.string.title_event);

        // Adding data to listview using Places class
        /*
        event1.setM_PlaceImageId(R.drawable.chandrashila1);
        event1.setM_EventDate(String.valueOf(R.string.event1_date));
        event1.setM_PlaceName(String.valueOf(R.string.event1_place));
        event1.setM_Duration(String.valueOf(R.string.event1_duration));
        event1.setM_Cost(String.valueOf(R.string.event1_cost));
        event1.setM_Phone(String.valueOf(R.string.event1_phone));

        m_EventsList.add(event1);
*/

        m_EventsList.add(new Events(R.drawable.chandrashila1,
                getResources().getString(R.string.event1_date),
                getResources().getString(R.string.event1_place),
                getResources().getString(R.string.event1_duration),
                getResources().getString(R.string.event1_cost),
                getResources().getString(R.string.event1_phone)));

        m_EventsList.add(new Events(R.drawable.triund1,
                getResources().getString(R.string.event2_date),
                getResources().getString(R.string.event2_place),
                getResources().getString(R.string.event2_duration),
                getResources().getString(R.string.event2_cost),
                getResources().getString(R.string.event2_phone)));

        m_EventsList.add(new Events(R.drawable.nagtibba1,
                getResources().getString(R.string.event3_date),
                getResources().getString(R.string.event3_place),
                getResources().getString(R.string.event3_duration),
                getResources().getString(R.string.event3_cost),
                getResources().getString(R.string.event3_phone)));

        m_EventsAdapter = new EventsAdapter(getApplicationContext(), m_EventsList);
        m_Events_ListView.setAdapter(m_EventsAdapter);

        //Action to perform when back button is pressed
        m_Back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsActivity.this, HomeActivity.class));
            }
        });
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
        startActivity(new Intent(EventsActivity.this,HomeActivity.class));
    }

    // 4. Function for Destinations button
    public void menuDestinations(View view){
        startActivity(new Intent(EventsActivity.this,DestinationsActivity.class));
    }

    // 5. Function for Favourite button
    public void menuFavourite(View view){
        startActivity(new Intent(EventsActivity.this,FavouriteActivity.class));
    }

    // 6. Function for Event button
    public void menuEvent(View view){
        Toast.makeText(getApplicationContext(),R.string.toast_events,Toast.LENGTH_LONG).show();
        menuDialog.dismiss();
    }
}

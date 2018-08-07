package com.pikchillytechnologies.mounttour;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FavouriteActivity extends AppCompatActivity {

    // Variable Declarations
    private TextView m_Title_TextView;
    private Button m_Back_Button;
    private FavouriteAdapter m_DestinationsAdapter;
    private List<Places> m_AllPlacesList;
    private ListView m_Places_ListView;
    Dialog menuDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        //Initialize Variables
        m_Title_TextView = findViewById(R.id.textView_Title);
        m_Places_ListView = findViewById(R.id.listView_Favourite);
        m_Back_Button = findViewById(R.id.button_Back);
        m_AllPlacesList = new ArrayList<>();
        menuDialog = new Dialog(this);

        // Set Title of the Activity to Destinations
        m_Title_TextView.setText(R.string.title_favourite);

        // Adding data to listview using Places class
        m_AllPlacesList.add(new Places(getResources().getString(R.string.dest1_name),
                getResources().getString(R.string.dest1_city),
                getResources().getString(R.string.dest1_state),
                getResources().getString(R.string.dest1_about),
                getResources().getString(R.string.dest1_howtoreach),
                getResources().getString(R.string.dest1_hotel),
                getResources().getString(R.string.dest1_bank),
                getResources().getString(R.string.dest1_medical),
                R.drawable.nagtibba1, R.drawable.nagtibba2, R.drawable.nagtibba3));

        m_AllPlacesList.add(new Places(getResources().getString(R.string.dest2_name),
                getResources().getString(R.string.dest2_city),
                getResources().getString(R.string.dest2_state),
                getResources().getString(R.string.dest2_about),
                getResources().getString(R.string.dest2_howtoreach),
                getResources().getString(R.string.dest2_hotel),
                getResources().getString(R.string.dest2_bank),
                getResources().getString(R.string.dest2_medical),
                R.drawable.parasharlake1, R.drawable.parasharlake2, R.drawable.parasharlake3));

        m_AllPlacesList.add(new Places(getResources().getString(R.string.dest3_name),
                getResources().getString(R.string.dest3_city),
                getResources().getString(R.string.dest3_state),
                getResources().getString(R.string.dest3_about),
                getResources().getString(R.string.dest3_howtoreach),
                getResources().getString(R.string.dest3_hotel),
                getResources().getString(R.string.dest3_bank),
                getResources().getString(R.string.dest3_medical),
                R.drawable.chandrashila1, R.drawable.chandrashila2, R.drawable.chandrashila3));

        m_DestinationsAdapter = new FavouriteAdapter(getApplicationContext(), m_AllPlacesList);
        m_Places_ListView.setAdapter(m_DestinationsAdapter);

        //Action to perform when back button is pressed
        m_Back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FavouriteActivity.this, HomeActivity.class));
            }
        });

        m_Places_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Places placeObject = m_AllPlacesList.get(position);
                Intent destinationDetailIntent = new Intent(FavouriteActivity.this, DestinationDetailActivity.class);
                destinationDetailIntent.putExtra(getResources().getString(R.string.myPlaceKey), placeObject);
                destinationDetailIntent.putExtra(getResources().getString(R.string.source), getResources().getString(R.string.act_favourite));
                startActivity(destinationDetailIntent);
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
        startActivity(new Intent(FavouriteActivity.this,HomeActivity.class));
    }

    // 4. Function for Destinations button
    public void menuDestinations(View view){
        startActivity(new Intent(FavouriteActivity.this,DestinationsActivity.class));
    }

    // 5. Function for Favourite button
    public void menuFavourite(View view){
        Toast.makeText(getApplicationContext(),R.string.toast_favourite,Toast.LENGTH_LONG).show();
        menuDialog.dismiss();
    }

    // 6. Function for Event button
    public void menuEvent(View view){
        startActivity(new Intent(FavouriteActivity.this,EventsActivity.class));
    }

    // 7. Function for Visited button
    public void visitedEvent(View view){
        startActivity(new Intent(FavouriteActivity.this,VisitedActivity.class));
    }
}

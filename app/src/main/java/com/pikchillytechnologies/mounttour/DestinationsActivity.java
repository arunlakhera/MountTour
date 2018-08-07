package com.pikchillytechnologies.mounttour;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
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

public class DestinationsActivity extends AppCompatActivity {

    // Variable Declarations
    private TextView m_Title_TextView;
    private Button m_Back_Button;
    private DestinationsAdapter m_DestinationsAdapter;
    private List<Places> m_AllPlacesList;
    private ListView m_Places_ListView;
    Dialog menuDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destinations);

        //Initialize Variables
        m_Title_TextView = findViewById(R.id.textView_Title);
        m_Places_ListView = findViewById(R.id.listView_Destinations);
        m_Back_Button = findViewById(R.id.button_Back);
        m_AllPlacesList = new ArrayList<>();
        menuDialog = new Dialog(this);

        // Set Title of the Activity to Destinations
        m_Title_TextView.setText(R.string.title_destination);

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

        m_AllPlacesList.add(new Places(getResources().getString(R.string.dest4_name),
                getResources().getString(R.string.dest4_city),
                getResources().getString(R.string.dest4_state),
                getResources().getString(R.string.dest4_about),
                getResources().getString(R.string.dest4_howtoreach),
                getResources().getString(R.string.dest4_hotel),
                getResources().getString(R.string.dest4_bank),
                getResources().getString(R.string.dest4_medical),
                R.drawable.triund1, R.drawable.triund2, R.drawable.triund3
        ));

        m_AllPlacesList.add(new Places(getResources().getString(R.string.dest5_name),
                getResources().getString(R.string.dest5_city),
                getResources().getString(R.string.dest5_state),
                getResources().getString(R.string.dest5_about),
                getResources().getString(R.string.dest5_howtoreach),
                getResources().getString(R.string.dest5_hotel),
                getResources().getString(R.string.dest5_bank),
                getResources().getString(R.string.dest5_medical),
                R.drawable.tirthan1, R.drawable.tirthan2, R.drawable.tirthan3));

        m_AllPlacesList.add(new Places(getResources().getString(R.string.dest6_name),
                getResources().getString(R.string.dest6_city),
                getResources().getString(R.string.dest6_state),
                getResources().getString(R.string.dest6_about),
                getResources().getString(R.string.dest6_howtoreach),
                getResources().getString(R.string.dest6_hotel),
                getResources().getString(R.string.dest6_bank),
                getResources().getString(R.string.dest6_medical),
                R.drawable.kheerganga1, R.drawable.kheerganga2, R.drawable.kheerganga3));

        m_DestinationsAdapter = new DestinationsAdapter(getApplicationContext(), m_AllPlacesList);
        m_Places_ListView.setAdapter(m_DestinationsAdapter);

        // Action to perform when Back button is clicked
        m_Back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DestinationsActivity.this, HomeActivity.class));
            }
        });

        m_Places_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Places placeObject = m_AllPlacesList.get(position);
                Intent destinationDetailIntent = new Intent(DestinationsActivity.this, DestinationDetailActivity.class);
                destinationDetailIntent.putExtra(getResources().getString(R.string.myPlaceKey), placeObject);
                destinationDetailIntent.putExtra(getResources().getString(R.string.source), getResources().getString(R.string.act_destination));
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
        startActivity(new Intent(DestinationsActivity.this,HomeActivity.class));
    }

    // 4. Function for Destinations button
    public void menuDestinations(View view){
        Toast.makeText(getApplicationContext(),R.string.toast_destinations,Toast.LENGTH_LONG).show();
        menuDialog.dismiss();
    }

    // 5. Function for Favourite button
    public void menuFavourite(View view){
        startActivity(new Intent(DestinationsActivity.this,FavouriteActivity.class));
    }

    // 6. Function for Event button
    public void menuEvent(View view){
        startActivity(new Intent(DestinationsActivity.this,EventsActivity.class));
    }
}

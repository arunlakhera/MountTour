package com.pikchillytechnologies.mounttour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class DestinationDetailActivity extends AppCompatActivity {

    Places placeObject;
    int imageNumber;
    String m_Source;
    // Variable Declaration
    private Button m_Back_Button;
    private Button m_Prev_Button;
    private Button m_Next_Button;
    private Button m_Add_Button;
    private ImageView m_DestinationLoop_ImageView;
    private TextView m_About_TextView;
    private TextView m_Location_TextView;
    private TextView m_HowToReach_TextView;
    private TextView m_Hotel_TextView;
    private TextView m_Bank_TextView;
    private TextView m_Medical_TextView;
    private TextView m_Title_TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_detail);

        // Initialize Variables
        imageNumber = 1;
        placeObject = getIntent().getParcelableExtra("myPlaceKey");
        m_Source = getIntent().getStringExtra("source");
        m_Back_Button = findViewById(R.id.button_Back);
        m_Prev_Button = findViewById(R.id.button_Prev);
        m_Next_Button = findViewById(R.id.button_Next);
        m_Add_Button = findViewById(R.id.button_Add);
        m_DestinationLoop_ImageView = findViewById(R.id.imageView_DestinationLoop);
        m_About_TextView = findViewById(R.id.textView_About);
        m_Location_TextView = findViewById(R.id.textView_Location);
        m_HowToReach_TextView = findViewById(R.id.textView_HowToReach);
        m_Hotel_TextView = findViewById(R.id.textView_Hotel);
        m_Bank_TextView = findViewById(R.id.textView_Bank);
        m_Medical_TextView = findViewById(R.id.textView_Medical);
        m_Title_TextView = findViewById(R.id.textView_Title);

        // Set values for views
        m_About_TextView.setText(placeObject.getM_About());
        m_Location_TextView.setText(placeObject.getM_CityName());
        m_HowToReach_TextView.setText(placeObject.getM_HowToReach());
        m_Hotel_TextView.setText(placeObject.getM_Hotel());
        m_Bank_TextView.setText(placeObject.getM_Bank());
        m_Medical_TextView.setText(placeObject.getM_Medical());
        m_DestinationLoop_ImageView.setImageResource(placeObject.getM_PlaceImageId1());
        m_Title_TextView.setText(placeObject.getM_PlaceName());

        // If source of intent was Favourite Activity then hide the Add Button as destination already added
        if (m_Source.equals("Favourite")) {
            m_Add_Button.setVisibility(View.INVISIBLE);
        } else {
            m_Add_Button.setVisibility(View.VISIBLE);
        }

        //Action to perform when back button is pressed
        m_Back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent previousIntent;
                previousIntent = new Intent(DestinationDetailActivity.this, DestinationDetailActivity.class);

                if (m_Source.equals("Destination")) {
                    previousIntent = new Intent(DestinationDetailActivity.this, DestinationsActivity.class);

                } else if (m_Source.equals("Favourite")) {
                    previousIntent = new Intent(DestinationDetailActivity.this, FavouriteActivity.class);

                }
                startActivity(previousIntent);
            }
        });

        m_DestinationLoop_ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(DestinationDetailActivity.this, GalleryActivity.class);
                galleryIntent.putExtra("source", m_Source);
                galleryIntent.putExtra("myPlaceKey", placeObject);
                galleryIntent.putExtra("imageNumber", imageNumber);
                startActivity(galleryIntent);
            }
        });

        // Show Next Image
        m_Next_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageNumber++;

                if (imageNumber == 2) {
                    m_DestinationLoop_ImageView.setImageResource(placeObject.getM_PlaceImageId2());
                } else if (imageNumber == 3) {
                    m_DestinationLoop_ImageView.setImageResource(placeObject.getM_PlaceImageId3());
                } else {
                    m_DestinationLoop_ImageView.setImageResource(placeObject.getM_PlaceImageId1());
                    imageNumber = 1;
                }
            }
        });

        // Show Previous Image
        m_Prev_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageNumber--;

                if (imageNumber == 0) {
                    m_DestinationLoop_ImageView.setImageResource(placeObject.getM_PlaceImageId3());
                } else if (imageNumber == 2) {
                    m_DestinationLoop_ImageView.setImageResource(placeObject.getM_PlaceImageId2());
                } else {
                    m_DestinationLoop_ImageView.setImageResource(placeObject.getM_PlaceImageId1());
                    imageNumber = 1;
                }
            }
        });

        // Add Destination as favourite
        m_Add_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Destination added to My Favourite", Toast.LENGTH_LONG).show();
            }
        });
    }
}

package com.pikchillytechnologies.mounttour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GalleryActivity extends AppCompatActivity {

    // Variable Declaration
    Places placeObject;
    int m_ImageNumber;
    private Button m_Back_Button;
    private ImageView m_PlaceImage;
    private Button m_Next_Button;
    private Button m_Prev_Button;
    private String m_Source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        // Initialize Variables
        m_Back_Button = findViewById(R.id.button_Back);
        m_PlaceImage = findViewById(R.id.imageView_PlaceImage);
        m_Prev_Button = findViewById(R.id.button_Prev);
        m_Next_Button = findViewById(R.id.button_Next);

        m_Source = getIntent().getStringExtra(getResources().getString(R.string.source));
        placeObject = getIntent().getParcelableExtra(getResources().getString(R.string.myPlaceKey));
        m_ImageNumber = getIntent().getExtras().getInt(getResources().getString(R.string.imageNumber));

        if (m_ImageNumber == 2) {
            m_PlaceImage.setImageResource(placeObject.getM_PlaceImageId2());
        } else if (m_ImageNumber == 3) {
            m_PlaceImage.setImageResource(placeObject.getM_PlaceImageId3());
        } else {
            m_PlaceImage.setImageResource(placeObject.getM_PlaceImageId1());
            m_ImageNumber = 1;
        }

        //Action to perform when back button is pressed
        m_Back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(GalleryActivity.this, DestinationDetailActivity.class);
                galleryIntent.putExtra(getResources().getString(R.string.source), m_Source);
                galleryIntent.putExtra(getResources().getString(R.string.myPlaceKey), placeObject);
                startActivity(galleryIntent);
            }
        });

        // Show Next Image
        m_Next_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                m_ImageNumber++;

                if (m_ImageNumber == 2) {
                    m_PlaceImage.setImageResource(placeObject.getM_PlaceImageId2());
                } else if (m_ImageNumber == 3) {
                    m_PlaceImage.setImageResource(placeObject.getM_PlaceImageId3());
                } else {
                    m_PlaceImage.setImageResource(placeObject.getM_PlaceImageId1());
                    m_ImageNumber = 1;
                }
            }
        });

        // Show Previous Image
        m_Prev_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                m_ImageNumber--;

                if (m_ImageNumber == 0) {
                    m_PlaceImage.setImageResource(placeObject.getM_PlaceImageId3());
                } else if (m_ImageNumber == 2) {
                    m_PlaceImage.setImageResource(placeObject.getM_PlaceImageId2());
                } else {
                    m_PlaceImage.setImageResource(placeObject.getM_PlaceImageId1());
                    m_ImageNumber = 1;
                }
            }
        });
    }
}

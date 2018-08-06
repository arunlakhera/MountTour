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
        m_AllPlacesList.add(new Places("Nag Tibba",
                "Mussoorie",
                "Uttarakhand",
                "Nag Tibba trek gives you the unmatched experience of trekking on one of the most beautiful landscapes in Uttarakhand with lush green meadows and snow-capped mountains. The panorama of the Himalayan snow peaks of Garhwal and Himachal offers views of famous peaks Bandarpoonch, Swargarohini, Srikanth and Black peak",
                "Delhi-Dehradun-Pantwari-Nag Tibba",
                "Mussoorie",
                "Mussoorie",
                "Mussoorie",
                R.drawable.nagtibba1, R.drawable.nagtibba2, R.drawable.nagtibba3));

        m_AllPlacesList.add(new Places("Triund",
                "Mcleodganj",
                "Himanchal Pradesh",
                "Triund trek gives you the unmatched experience of trekking on one of the most beautiful landscapes in Himachal Pradesh with waterfalls, lush green meadows and snow-capped mountains. Triund trek is very much suitable in spring and summer as Triund temperature remains very suitable and weather at Triund & adjacent areas is becomes very enjoyable with beautiful sight of sky kissing high Himalayan peaks.",
                "Delhi-Mcleodganj-Triund Hill",
                "Mcleodganj",
                "Mcleodganj",
                "Mcleodganj",
                R.drawable.triund1, R.drawable.triund2, R.drawable.triund3));

        m_AllPlacesList.add(new Places("Tirthan",
                "Aut",
                "Himanchal Pradesh",
                "The Great Himalayan National Park in Himachal Pradesh offers lush meadows, snow clad peaks, the enchanting Tirthan River and Himalayan flora and fauna. It has distinct, endangered and regionally endemic Himalayan species – Himalayan Musk Deer and Snow Leopard being the prominent ones. Seek adventure on the Great Himalayan National Park Trek and spend days amidst the Himalayas by the Tirthan River.",
                "Delhi-Aut-Tirthan",
                "Aut",
                "Aut",
                "Aut",
                R.drawable.tirthan1, R.drawable.tirthan2, R.drawable.tirthan3));

        m_AllPlacesList.add(new Places("Kheer Ganga",
                "Uttarkashi",
                "Himanchal Pradesh",
                "The Parvati Valley is one of the most picturesque places in the Himalayan region of Himachal Pradesh. Two days is all you need to explore its magnificent landscape and get refreshed from within. The Kasol to Kheerganga trek is an invigorating journey, which not only unveils the stunning terrain of the Himalayas, but also gives you a chance to learn about the interesting culture of the people living here.",
                "Delhi-Kasol-Barshaini-Rudra Nag-Kheer Ganga",
                "Kasol",
                "Kasol",
                "Kasol",
                R.drawable.kheerganga1, R.drawable.kheerganga2, R.drawable.kheerganga3));

        m_AllPlacesList.add(new Places("Prashar Lake",
                "Mandi",
                "Himanchal Pradesh",
                "Prashar Lake lies 49 km north of Mandi, Himachal Pradesh, India, with a three storied pagoda-like temple dedicated to the sage Prashar. The lake is located at a height of 2730 m above sea level. With deep blue waters, the lake is held sacred to the sage Prashar and he is regarded to have meditated there. Surrounded by snow-capped peaks and looking down on the fast flowing river Beas, the lake can be approached via Drang.",
                "Delhi-Mandi-Prashar Lake",
                "Mandi",
                "Mandi",
                "Mandi",
                R.drawable.parasharlake1, R.drawable.parasharlake2, R.drawable.parasharlake3));

        m_AllPlacesList.add(new Places("Chandrashila Trek",
                "Tungnath",
                "Uttarakhand",
                "There are three reasons one must do this trek – the forests, the birds and the fabulous mountain views. Atop the peak, on a clear day, you can get a 360 degree view of peaks like Nanda Devi, Chaukhambha and Trishul. Another highlight of the trek is the chance to climb up to the world’s highest Shiva temple. Tungnath isthousand-year-old temple and is one of the five Panch Kedar, the holiest of Shiva temples. The sunrise from the Chandrashila summit wraps up the trek with strong emotions and memories to take back home.",
                "Delhi-Chopta-Tungnath",
                "Chandrapuri",
                "Chandrapuri",
                "Chandrapuri",
                R.drawable.chandrashila1, R.drawable.chandrashila2, R.drawable.chandrashila3));

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
                destinationDetailIntent.putExtra("myPlaceKey", placeObject);
                destinationDetailIntent.putExtra("source", "Destination");
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
        Toast.makeText(getApplicationContext(),"You are in Destinations Screen",Toast.LENGTH_LONG).show();
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

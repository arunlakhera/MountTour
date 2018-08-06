package com.pikchillytechnologies.mounttour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FavouriteActivity extends AppCompatActivity {

    // Variable Declarations
    private TextView m_Title_TextView;
    private Button m_Back_Button;
    private FavouriteAdapter m_DestinationsAdapter;
    private List<Places> m_AllPlacesList;
    private ListView m_Places_ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        //Initialize Variables
        m_Title_TextView = findViewById(R.id.textView_Title);
        m_Places_ListView = findViewById(R.id.listView_Favourite);
        m_Back_Button = findViewById(R.id.button_Back);
        m_AllPlacesList = new ArrayList<>();

        // Set Title of the Activity to Destinations
        m_Title_TextView.setText(R.string.title_favourite);

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
                destinationDetailIntent.putExtra("myPlaceKey", placeObject);
                destinationDetailIntent.putExtra("source", "Favourite");
                startActivity(destinationDetailIntent);
            }
        });
    }
}

package com.pikchillytechnologies.mounttour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EventsActivity extends AppCompatActivity {

    // Variable Declarations
    private TextView m_Title_TextView;
    private Button m_Back_Button;
    private EventsAdapter m_EventsAdapter;
    private List<Events> m_EventsList;
    private ListView m_Events_ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        //Initialize Variables
        m_Title_TextView = findViewById(R.id.textView_Title);
        m_Back_Button = findViewById(R.id.button_Back);

        m_Events_ListView = findViewById(R.id.listView_Events);
        m_EventsList = new ArrayList<>();

        m_Title_TextView.setText(R.string.title_event);

        // Adding data to listview using Places class
        m_EventsList.add(new Events(R.drawable.chandrashila1, "20 Aug 2018", "Chandrashila", "1N / 2D", "Rs.3500 per person", "+91 999 9999 999"));
        m_EventsList.add(new Events(R.drawable.triund1, "30 Aug 2018", "Triund", "2N / 2D", "Rs.4500 per person", "+91 999 9999 999"));
        m_EventsList.add(new Events(R.drawable.nagtibba1, "10 Sep 2018", "Nag Tibba", "1N / 2D", "Rs.2800 per person", "+91 999 9999 999"));

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
}

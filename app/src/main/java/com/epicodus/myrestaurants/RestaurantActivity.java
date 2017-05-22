package com.epicodus.myrestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RestaurantActivity extends AppCompatActivity {
    private TextView mLocationTextView;
    private ListView mListView;
    private String[] donuts = new String[] {"Pip's Original", "Coco Donuts", "Sesame Donuts", "Tonalli's"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        mListView = (ListView) findViewById(R.id.listView);
        mLocationTextView = (TextView) findViewById(R.id.locationTextView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, donuts);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String donut = ((TextView)view).getText().toString();
                Toast.makeText(RestaurantActivity.this, donut, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String zip = intent.getStringExtra("zip");
        mLocationTextView.setText("Yo, dawg. Here are all the donuts near "  + zip);
    }
}

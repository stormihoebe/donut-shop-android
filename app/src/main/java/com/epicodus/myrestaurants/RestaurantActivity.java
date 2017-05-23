package com.epicodus.myrestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RestaurantActivity extends AppCompatActivity {
    private String[] donuts = new String[] {"Pip's Original", "Coco Donuts", "Sesame Donuts", "Tonalli's"};
    public static final String TAG = RestaurantActivity.class.getSimpleName();
    private String[] donutTypes = new String[] {"mini", "classic", "sesame", "italian"};

    @Bind(R.id.locationTextView) TextView mLocationTextView;
    @Bind(R.id.listView) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        ButterKnife.bind(this);

        MyRestaurantArrayAdapter adapter = new MyRestaurantArrayAdapter(this, android.R.layout.simple_list_item_1, donuts, donutTypes);
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

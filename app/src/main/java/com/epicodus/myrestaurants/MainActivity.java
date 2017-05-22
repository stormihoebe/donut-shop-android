package com.epicodus.myrestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Typeface;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private EditText mZipEditText;
    private Button mEmberButton;
    private TextView mMyRestaurantsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mZipEditText = (EditText) findViewById(R.id.enterZip);
        mEmberButton = (Button) findViewById(R.id.emberButton);
            mEmberButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String zip = mZipEditText.getText().toString();
                    Log.d(TAG, zip);
                    Intent intent = new Intent(MainActivity.this, RestaurantActivity.class);
                    intent.putExtra("zip", zip);
                    startActivity(intent);
                }
            });
        mMyRestaurantsTextView = (TextView) findViewById(R.id.myRestaurantsTextView);
        Typeface pacificoFont = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        mMyRestaurantsTextView.setTypeface(pacificoFont);
    }
}

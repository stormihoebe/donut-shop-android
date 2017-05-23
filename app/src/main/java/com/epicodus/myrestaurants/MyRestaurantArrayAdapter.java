package com.epicodus.myrestaurants;
import android.content.Context;
import android.widget.ArrayAdapter;


public class MyRestaurantArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mDonuts;
    private String[] mDonutTypes;

    public MyRestaurantArrayAdapter(Context mContext, int resource, String[] mDonuts, String[] mDonutTypes){
        super(mContext, resource);
        this.mContext = mContext;
        this.mDonuts = mDonuts;
        this.mDonutTypes = mDonutTypes;
    }

    @Override
    public Object getItem(int position) {
        String donut = mDonuts[position];
        String type = mDonutTypes[position];
        return String.format("%s \nServes great: %s donuts", donut, type);
    }

    @Override
    public int getCount() {
        return  mDonuts.length;
    }
}


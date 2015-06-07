package com.mapkit.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.mapkit.test.pojo.Price;
import com.mapkit.test.pojo.Task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by LastVar on 07.06.2015.
 */
public class InfoActivity  extends Activity{

    public static final String TASK_EXTRA = "extra";
    private static final String DATE = "dd MMMM yyyy";

    private TextView mText;
    private TextView mLongText;
    private ListView mPrices;
    private TextView mLocDate;
    private Task mCurrentTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCurrentTask = new Gson().fromJson(getIntent().getStringExtra(TASK_EXTRA), Task.class);
        if ( mCurrentTask == null ) {
            finish();
            return;
        }

        setContentView(R.layout.info);

        Log.w("ZZZ", mCurrentTask.toString());
        mText = (TextView)findViewById(R.id.text);
        mText.setText(mCurrentTask.getText());

        mLongText = (TextView)findViewById(R.id.longtext);
        mLongText.setText(mCurrentTask.getLongText());

        mPrices = (ListView)findViewById(R.id.prices);
        mPrices.setAdapter(new PriceAdapter(mCurrentTask.getPrices()));

        mLocDate = (TextView)findViewById(R.id.date_location);
        DateFormat df = new SimpleDateFormat(DATE);
        String date = df.format(new Date(mCurrentTask.getDate()));
        mLocDate.setText(String.format("%s(%s)", mCurrentTask.getLocationText(), date));
    }

    private class PriceAdapter extends ArrayAdapter<Price> {

        PriceAdapter(List<Price> prices) {
            super(InfoActivity.this, 0, prices);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View result = (convertView == null ? LayoutInflater.from(getContext()).inflate(R.layout.price, parent, false) : convertView);

            TextView description = (TextView) result.findViewById(R.id.description);
            TextView priceView = (TextView) result.findViewById(R.id.price);

            Price price = getItem(position);
            description.setText(price.getDescription());
            priceView.setText(String.valueOf(price.getPrice()));

            return result;
        }
    }
}

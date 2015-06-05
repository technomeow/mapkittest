package com.mapkit.test;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mapkit.test.pojo.Task;
import ru.yandex.yandexmapkit.MapController;
import ru.yandex.yandexmapkit.MapView;
import ru.yandex.yandexmapkit.OverlayManager;
import ru.yandex.yandexmapkit.overlay.Overlay;
import ru.yandex.yandexmapkit.overlay.OverlayItem;
import ru.yandex.yandexmapkit.overlay.balloon.BalloonItem;
import ru.yandex.yandexmapkit.overlay.balloon.OnBalloonListener;
import ru.yandex.yandexmapkit.utils.GeoPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LastVar on 05.06.2015.
 */
public class MapActivity  extends Activity implements OnBalloonListener{

    private static final String URL = "http://test.boloid.com:9000/tasks";
    private static final String TAG = "MapActivity";
    private static final Gson gson = new Gson();

    private RequestQueue mQueue;
    private StringRequest mUpdateRequest;
    private MapView mMap;
    private MapController mMapController;
    private OverlayManager mOverlayManager;
    private Overlay mTasksOverlay;
    private List<Task> mTasks = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.map);

        mMap = (MapView)findViewById(R.id.map);
        mMapController = mMap.getMapController();
        mOverlayManager = mMapController.getOverlayManager();
        mOverlayManager.getMyLocation().setEnabled(false);

        mUpdateRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mTasks = gson.fromJson(response, new TypeToken<List<Task>>() {
                }.getType());
                loadTasks();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "request failed:" + error.toString());
            }
        });

        refreshTasks();

    }

    private void refreshTasks() {
        mQueue.add(mUpdateRequest);
    }

    private void loadTasks() {
        if (mTasksOverlay != null) {
            mOverlayManager.removeOverlay(mTasksOverlay);
        }
        mTasksOverlay = new Overlay(mMapController);
        Resources res = getResources();
        for(Task task : mTasks) {
            OverlayItem item = new OverlayItem(
                    new GeoPoint(task.getLocation().getLat(), task.getLocation().getLon()),
                    res.getDrawable(R.drawable.a));
            ExtendedBalloonItem balloon = new ExtendedBalloonItem(this, item.getGeoPoint());
            balloon.setOnBalloonListener(this);
            balloon.setText(task.getTitle());
            balloon.setTask(task);
            item.setBalloonItem(balloon);
            mTasksOverlay.addOverlayItem(item);
        }
        mOverlayManager.addOverlay(mTasksOverlay);
    }

    @Override
    public void onBalloonViewClick(BalloonItem balloonItem, View view) {
        if(!(balloonItem instanceof ExtendedBalloonItem)) {
            return;
        }
        Task task = ((ExtendedBalloonItem) balloonItem).getTask();
        if(task == null) {
            return;
        }

//        Intent intent = new Intent(this, XXX);
        //да, через parceable более правильно, но мне лень
//        intent.putExtra(XXX, gson.toJson(task));
//        startActivity(intent);
    }

    @Override
    public void onBalloonShow(BalloonItem balloonItem) {

    }

    @Override
    public void onBalloonHide(BalloonItem balloonItem) {

    }

    @Override
    public void onBalloonAnimationStart(BalloonItem balloonItem) {

    }

    @Override
    public void onBalloonAnimationEnd(BalloonItem balloonItem) {

    }
}

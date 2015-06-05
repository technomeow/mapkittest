package com.mapkit.test;

import android.content.Context;
import com.mapkit.test.pojo.Task;
import ru.yandex.yandexmapkit.overlay.balloon.BalloonItem;
import ru.yandex.yandexmapkit.utils.GeoPoint;

/**
 * Created by LastVar on 05.06.2015.
 */
public class ExtendedBalloonItem extends BalloonItem {

    private Task task;

    public ExtendedBalloonItem(Context context, GeoPoint geoPoint) {
        super(context, geoPoint);
    }

    @Override
    public int compareTo(Object another) {
        return 0;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}

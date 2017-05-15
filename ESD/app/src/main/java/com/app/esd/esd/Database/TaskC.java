package com.app.esd.esd.Database;

import android.provider.BaseColumns;

/**
 * Created by DOBYNT on 02/11/2016.
 */

public final class TaskC {
    public TaskC() {}

    public static abstract class Task implements BaseColumns {
        public static final String TABLE_NAME = "session";
        public static final String DATE = "date";
        public static final String TIME_HOUR = "time_hour";
        public static final String TIME_MINUTE = "time_minute";
        public static final String SCORE = "score";
    }
}

package com.app.esd.esd.Model;

/**
 * Created by Administrator on 16/05/2017.
 */

public class Session {
    public int id;
    public String date;
    public long time_hour;
    public long time_minute;
    public int score;

    public Session() {
    }

    public Session(int id, String date, long time_hour, long time_minute, int score) {
        this.id = id;
        this.date = date;
        this.time_hour = time_hour;
        this.time_minute = time_minute;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getTime_hour() {
        return time_hour;
    }

    public void setTime_hour(long time_hour) {
        this.time_hour = time_hour;
    }

    public long getTime_minute() {
        return time_minute;
    }

    public void setTime_minute(long time_minute) {
        this.time_minute = time_minute;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

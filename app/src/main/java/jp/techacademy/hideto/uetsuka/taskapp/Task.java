package jp.techacademy.hideto.uetsuka.taskapp;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Airhead-Kangaroo on 2017/04/25.
 */

public class Task extends RealmObject implements Serializable {
    private String title;
    private String contents;
    private Date date;

    @PrimaryKey
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

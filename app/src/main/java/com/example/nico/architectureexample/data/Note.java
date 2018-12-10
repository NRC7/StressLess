package com.example.nico.architectureexample.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//This class represent our entity
//TableName by default is Class name but "note_table" is more SQL-like name
//@Entity annotation means that this java class will be a table
@Entity (tableName = "note_table")
public class Note {

    //in order to give every entry a unique key to identify each one,
    //use annotation @PrimaryKey(autoGenerate = true) on a int variable call id,
    //this way id will increment auto starting with 1
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String description;

    //whit annotation @ColumnInfo(name = "priority_colum") you name set this column a custom name
    private int priority;

    //id will auto generated
    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    //if id is not generated you need just a setter even when you get an error in compile time
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}

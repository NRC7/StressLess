package com.example.nico.architectureexample.data;

import com.example.nico.architectureexample.data.Note;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

//Annotation @DAO handles all default table methods like insert, delete, update
//DAOs handles custom table methods using @Query annotation
@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    //Delete all the notes with custom methods
    //If you dont write anything between DELETE and FROM means that you want to delete all
    //@Query annotation receive a string
    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    //This methods put all the notes in the recycler view
    //This select from our table all the notes returning a list of notes,
    //ordered by our variable priority in descending order
    //Room can use LiveDate right away because the imported dependencies
    //LiveData will observ this object, so as soon there are any changes to your table,
    //the return value of our method will be updated and our activity will be notified
    // this "*" means all colums
    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Note>> getAllNotes();

}

package com.ticketcount.busticketcounter.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TicketDao {

    @Query("SELECT * FROM ticketdb")
    List<TicketDB> retrieveData();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveData(TicketDB ticketdata);

    @Delete
    void deleteData(TicketDB ticketDB);


}

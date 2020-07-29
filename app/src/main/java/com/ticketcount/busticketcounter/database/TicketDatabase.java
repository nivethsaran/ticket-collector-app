package com.ticketcount.busticketcounter.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {TicketDB.class},version = 1)
public abstract class TicketDatabase extends RoomDatabase {
    public abstract TicketDao ticketDao();
}
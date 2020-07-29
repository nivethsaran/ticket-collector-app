package com.ticketcount.busticketcounter.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ticketdb")
public class TicketDB {

    @NonNull
    public String details;

    @NonNull
    public String ticketype;

    @NonNull @PrimaryKey
    public long date;

}
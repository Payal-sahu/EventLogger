package com.example.eventproject.eventProject.Util;

import java.util.ArrayList;

import com.example.eventproject.eventProject.Models.Event;

public class DBUtil {
	public static String createTableStatement() {
		return "CREATE TABLE events ("+
                "id VARCHAR(50) NOT NULL, duration INT NOT NULL,"+
                "type VARCHAR(50), host VARCHAR(50), alert BOOLEAN, "+
                "PRIMARY KEY (id));";
	}
	
	public static String insertEventQuery(Event event) {
		String query = "INSERT INTO events VALUES ('"+event.id+"',"+String.valueOf(event.duration)+", '"+
						event.type+"', '"+event.host+"',"+String.valueOf(event.alert)+");";
		return query;
	}
}

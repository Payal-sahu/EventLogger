package com.example.eventproject.eventProject.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.yaml.snakeyaml.events.CollectionStartEvent;

import com.example.eventproject.eventProject.Models.Event;
import com.example.eventproject.eventProject.Models.Log;
import com.google.gson.Gson;

public class Util {
	public static void flagEvent(Event event) {
		if(event.duration > 4) {
			event.alert = true;
		}
	}
	
	public static String createTableStatement() {
		return "CREATE TABLE events ("+
                "id VARCHAR(50) NOT NULL, duration INT NOT NULL,"+
                "type VARCHAR(50), host VARCHAR(50), alert BOOLEAN, "+
                "PRIMARY KEY (id));";
	}

	public static ArrayList<String> readFromFile(String fileName) throws Exception {
		File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String> lines = new ArrayList<>();
        String st;
        while ((st = br.readLine()) != null) {
        	lines.add(st);
        }
    	return lines;
	}

	public static ArrayList<Log> createLogs(ArrayList<String> lines) {
		ArrayList<Log> logs = new ArrayList<>();
		Gson g = new Gson();
		for(String line: lines) {
			Log log = g.fromJson(line, Log.class); 
			logs.add(log);
		}
		return logs;
	}

	public static void sortWithIds(ArrayList<Log> logs) {
		Collections.sort(logs, (a, b)->{
			if(a.id.equals(b.id)) {
				if(a.timestamp > b.timestamp)return 1;
				return -1;
			}
			return a.id.compareTo(b.id);
		});
		
	}

	public static ArrayList<Event> createEventsfromLogs(ArrayList<Log> logs) {
		ArrayList<Event> events = new ArrayList<>();
		int size = logs.size();
		for(int i=0; i<size; i += 2) {
			Log log1 = logs.get(i);
			Log log2 = logs.get(i+1);
			Event event = new Event(log1.id, log2.timestamp-log1.timestamp, log1.type, log1.host, false);
			flagEvent(event);
			events.add(event);
		}
		return events;
	}

	public static ArrayList<Event> preProcess(String f) throws Exception{
		ArrayList<String> lines = Util.readFromFile(f);
		ArrayList<Log> logs = Util.createLogs(lines);
		Util.sortWithIds(logs);
		ArrayList<Event> events = Util.createEventsfromLogs(logs);
		return events;
	}
}

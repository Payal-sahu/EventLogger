package com.example.eventproject.eventProject.Models;

public class Event {
	public String id;
	public long duration;
	public String type;
	public String host;
	public boolean alert;
	
	public Event(String id, long duration, String type, String host, boolean alert) {
		super();
		this.id = id;
		this.duration = duration;
		this.type = type;
		this.host = host;
		this.alert = alert;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", duration=" + duration + ", type=" + type + ", host=" + host + ", alert=" + alert
				+ "]";
	}
	
	
}

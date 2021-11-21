package com.example.eventproject.eventProject.Models;

public class Log {
    public String id;
    public String state;
    public String type;
    public String host;
    public long timestamp;
    
	public Log(String id, String state, String type, String host, long timestamp) {
		super();
		this.id = id;
		this.state = state;
		this.type = type;
		this.host = host;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", state=" + state + ", type=" + type + ", host=" + host + ", timestamp=" + timestamp
				+ "]";
	}
}
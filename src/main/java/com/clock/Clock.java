package com.clock;

import java.sql.Timestamp;

public class Clock {
	private long id;
	private String key;
	Timestamp alarm;
	
	public Clock(long id, String key, Timestamp alarm){
		this.id = id;
		this.key = key;
		this.alarm = alarm;
	}
	
	public Clock(long id, Timestamp alarm){
		this.id = id;
		this.alarm = alarm;
	}
	
	public Clock(){};
	
	@Override
	public String toString() {
		return String.format(
				"Clock[id=%d, key='%s', alarm='%s']",
				id, key, alarm );
	}
	public long getId() {
		return id;
	}
	public Timestamp getAlarm() {
		return alarm;
	}
	public String getKey() {
		return key;
	}
	public void setAlarm(Timestamp alarm) {
		this.alarm = alarm;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setKey(String key) {
		this.key = key;
	}
}

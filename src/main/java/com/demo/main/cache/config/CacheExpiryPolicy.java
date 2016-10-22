package com.demo.main.cache.config;

public class CacheExpiryPolicy {

	String type;
	long duration;
	String timeUnit;
	
	
	@Override
	public String toString() {
		return "CacheExpiryPolicy [type=" + type + ", duration=" + duration + ", timeUnit=" + timeUnit + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getTimeUnit() {
		return timeUnit;
	}
	public void setTimeUnit(String timeUnit) {
		this.timeUnit = timeUnit;
	}
}

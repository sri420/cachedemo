package com.demo.main.cache.config;

public class CacheEvictionPolicy {

	String type;
	String maxSize;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(String maxSize) {
		this.maxSize = maxSize;
	}
	@Override
	public String toString() {
		return "CacheEvictionPolicy [type=" + type + ", maxSize=" + maxSize + "]";
	}
	
}

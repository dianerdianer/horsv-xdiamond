package com.horsv.xdiamond.client.event;

import com.alibaba.fastjson.JSON;

/**
 * 配置时间bean
 */
public class ConfigEvent {
	//key
	String key;
	//旧值
	String oldValue;
	//新值
	String value;

	//事件类型
	EventType eventType;

	public ConfigEvent(String key, String value, String oldValue, EventType eventType) {
		super();
		this.key = key;
		this.value = value;
		this.oldValue = oldValue;
		this.eventType = eventType;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}

package com.university.of.hull.eportal.datamodel.events;

import java.util.List;

import com.university.of.hull.eportal.datamodel.Message;

public class FetchEventResponse extends Message {

	private CreateEventRequest event;
	
	private List<CreateEventRequest> eventList;

	public CreateEventRequest getEvent() {
		return event;
	}

	public void setEvent(CreateEventRequest event) {
		this.event = event;
	}

	public List<CreateEventRequest> getEventList() {
		return eventList;
	}

	public void setEventList(List<CreateEventRequest> eventList) {
		this.eventList = eventList;
	}

	
}

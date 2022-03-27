package com.university.of.hull.eportal.datamodel.events;

import java.sql.Timestamp;

public class CreateEventRequest{

	private String title;
	private String description;
	private String location;
	private int cost;
	private String imgVidPath;
	private Long availableSeats;
	private String clubId;
	private Timestamp startDateAndTime;
	private Timestamp endDateAndTime;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getImgVidPath() {
		return imgVidPath;
	}

	public void setImgVidPath(String imgVidPath) {
		this.imgVidPath = imgVidPath;
	}

	public Long getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Long availableSeats) {
		this.availableSeats = availableSeats;
	}

	public String getClubId() {
		return clubId;
	}

	public void setClubId(String clubId) {
		this.clubId = clubId;
	}

	public Timestamp getStartDateAndTime() {
		return startDateAndTime;
	}

	public void setStartDateAndTime(Timestamp startDateAndTime) {
		this.startDateAndTime = startDateAndTime;
	}

	public Timestamp getEndDateAndTime() {
		return endDateAndTime;
	}

	public void setEndDateAndTime(Timestamp endDateAndTime) {
		this.endDateAndTime = endDateAndTime;
	}
}

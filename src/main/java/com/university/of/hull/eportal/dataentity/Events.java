package com.university.of.hull.eportal.dataentity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "e_portal_events")
public class Events implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_id")
	private Long eventId;

	@Column(name = "event_title")
	private String title;

	@Column(name = "event_description")
	private String description;

	@Column(name = "event_location")
	private String location;

	@Column(name = "event_cost")
	private int cost;

	@Column(name = "event_image_or_video_path")
	private String imgVidPath;

	@Column(name = "event_available_seats")
	private Long availableSeats;

	@Column(name = "event_start_date_time")
	private Timestamp startDateAndTime;

	@Column(name = "event_end_date_time")
	private Timestamp endDateAndTime;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "club_id", referencedColumnName = "club_id")
	private Clubs club;

	public Long getId() {
		return eventId;
	}

	public void setId(Long id) {
		this.eventId = id;
	}

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

	public Clubs getClub() {
		return club;
	}

	public void setClub(Clubs club) {
		this.club = club;
	}
}

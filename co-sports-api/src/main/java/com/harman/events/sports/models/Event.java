package com.harman.events.sports.models;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer eventId;
	private String eventName;
	private String eventVenue;
	private Date eventDate;
	private Long maximumParticipants;
	private Long numberOfParticipants;
	private String eventStatus;
	private String registrationStatus;

	public Event() {
		
	}
	
	public Event(Integer eventId, String eventName, String eventVenue, Date eventDate, Long maximumParticipants,
			Long numberOfParticipants, String eventStatus, String registrationStatus) {
		
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.eventDate = eventDate;
        this.maximumParticipants = maximumParticipants;
        this.numberOfParticipants = numberOfParticipants;
        this.eventStatus = eventStatus;       
        this.registrationStatus = registrationStatus;
    }

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventVenue() {
		return eventVenue;
	}

	public void setEventVenue(String eventVenue) {
		this.eventVenue = eventVenue;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Long getMaximumParticipants() {
		return maximumParticipants;
	}

	public void setMaximumParticipants(Long maximumParticipants) {
		this.maximumParticipants = maximumParticipants;
	}

	public Long getNumberOfParticipants() {
		return numberOfParticipants;
	}

	public void setNumberOfParticipants(Long numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}

	public String getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	public String getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	} 
}

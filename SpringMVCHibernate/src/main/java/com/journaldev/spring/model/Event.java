package com.journaldev.spring.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity  
@Table(name = "event")  
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
public class Event implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Event() {
		
	}
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "event_id")  
	private Integer eventId;
	

	@Column(name = "event_name")  
	private String eventName;
	@Column(name = "event_venue")  
	private String eventVenue;
	@Column(name = "event_date")  
	private Date eventDate;
	@Column(name = "max_participants")
	private Long maximumParticipants;
	@Column(name = "number_of_participants")
	private Long numberOfPaticipants;
	@Column(name = "event_status")  
	private String eventStatus;
	@Column(name = "registration_status")  
	private String registrationStatus;
	
	
	public Event(Integer eventId, String eventName, String eventVenue, Date eventDate, Long maximumParticipants,
			Long numberOfPaticipants, String eventStatus, String registrationStatus) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.eventDate = eventDate;
        this.maximumParticipants = maximumParticipants;
        this.numberOfPaticipants = numberOfPaticipants;
        this.eventStatus = eventStatus;       
        this.registrationStatus = registrationStatus;
        
    }
	
	
	public Integer getEventId() {
		return eventId;
	}

	
	public Long getNumberOfPaticipants() {
		return numberOfPaticipants;
	}

	public void setNumberOfPaticipants(Long numberOfPaticipants) {
		this.numberOfPaticipants = numberOfPaticipants;
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

    public Event(String name, String text) {
       
    }
 

}

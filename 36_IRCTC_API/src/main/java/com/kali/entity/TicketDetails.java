package com.kali.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TICKET_DTLS")
public class TicketDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketId;
	private String passengerName;
	private Date dob;
	private String gender;
	private Integer trainNum;
	private String source;
	private String destination;
	private Date doj;
	private String ticketStaus;
	
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getTrainNum() {
		return trainNum;
	}
	public void setTrainNum(Integer trainNum) {
		this.trainNum = trainNum;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String from) {
		this.source = from;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String to) {
		this.destination = to;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getTicketStaus() {
		return ticketStaus;
	}
	public void setTicketStaus(String ticketStaus) {
		this.ticketStaus = ticketStaus;
	}
	
}

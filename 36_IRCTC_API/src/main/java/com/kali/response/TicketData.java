package com.kali.response;

import java.sql.Date;

public class TicketData {

	private Integer ticketId;
	private String ticketStaus;
	private Integer trainNum;
	private String from;
	private String to;
	private Date doj;
	private String passengerName;
	
	
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	
	public String getTicketStaus() {
		return ticketStaus;
	}
	public void setTicketStaus(String ticketStaus) {
		this.ticketStaus = ticketStaus;
	}
	public Integer getTrainNum() {
		return trainNum;
	}
	public void setTrainNum(Integer trainNum) {
		this.trainNum = trainNum;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

}

package com.rapidraider.Entity;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Register_Tournament")
public class RegisterTour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private Long tournamentID;
    private String tournamentName;
    private String organizerName;
    private String tournamentDescription;
    private LocalDate startDate;
    private LocalDate endDate;
    private String locationValue;
    private String tournamentFormat;
    private long entryFees;
    private String phoneNo;
    
    //Generating getters and setters 
	public Long getTournamentID() {
		return tournamentID;
	}
	public void setTournamentID(Long tournamentID) {
		this.tournamentID = tournamentID;
	}
	public String getTournamentName() {
		return tournamentName;
	}
	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}
	public String getOrganizerName() {
		return organizerName;
	}
	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}
	public String getTournamentDescription() {
		return tournamentDescription;
	}
	public void setTournamentDescription(String tournamentDescription) {
		this.tournamentDescription = tournamentDescription;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getLocationValue() {
		return locationValue;
	}
	public void setLocationValue(String locationValue) {
		this.locationValue = locationValue;
	}
	public String getTournamentFormat() {
		return tournamentFormat;
	}
	public void setTournamentFormat(String tournamentFormat) {
		this.tournamentFormat = tournamentFormat;
	}
	public long getEntryFees() {
		return entryFees;
	}
	public void setEntryFees(long entryFees) {
		this.entryFees = entryFees;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	//generating toString
	@Override
	public String toString() {
		return "RegisterTour [tournamentID=" + tournamentID + ", tournamentName=" + tournamentName + ", organizerName="
				+ organizerName + ", tournamentDescription=" + tournamentDescription + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", locationValue=" + locationValue + ", tournamentFormat=" + tournamentFormat
				+ ", entryFees=" + entryFees + ", phoneNo=" + phoneNo + "]";
	}
	
	

    
    
}


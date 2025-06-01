package com.mycar.nhom13.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Reports")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_id")
	private int reportId;
	@ManyToOne
	@JoinColumn(name = " rental_id")
	@JsonIgnore
	private Rental rental;
	@Column(name = "state")
	private String state;
	@Column(name = "details")
	@Size(min = 1, message = "Nội dung không được để trống.")
	private String details;

	@Column(name = "report_date")
	private LocalDate date;

	public Report() {

	}

	public Report(int reportId, Rental rental, String state, String details, LocalDate date) {
		this.reportId = reportId;
		this.rental = rental;
		this.state = state;
		this.details = details;
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}

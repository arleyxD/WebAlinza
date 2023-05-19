package com.co.tiendas.indy.ccolombia.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "componet")
public class ComponenteModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long id;
	@Column(unique = true,nullable = false)
	private String SharedKey;
	private String BusinessID;
	private String email;
	private String phone;
	private Date StarDate;
	private Date Starend;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSharedKey() {
		return SharedKey;
	}
	public void setSharedKey(String sharedKey) {
		SharedKey = sharedKey;
	}
	public String getBusinessID() {
		return BusinessID;
	}
	public void setBusinessID(String businessID) {
		BusinessID = businessID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getStarDate() {
		return StarDate;
	}
	public void setStarDate(Date starDate) {
		StarDate = starDate;
	}
	public Date getStarend() {
		return Starend;
	}
	public void setStarend(Date starend) {
		Starend = starend;
	}
	
	
}

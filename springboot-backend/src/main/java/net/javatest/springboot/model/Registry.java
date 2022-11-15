package net.javatest.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "etRegistry")
public class Registry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "emerging_technology")
	private String emergingTechnology;

	@Column(name = "activity_type")
	private String activityType;
	
	@Column(name = "email_id")
	private String emailId;
	
	public Registry() {
		
	}
	
	public Registry(String emergingTechnology, String activityType, String emailId) {
		super();
		this.emergingTechnology = emergingTechnology;
		this.activityType = activityType;
		this.emailId = emailId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmergingTechnology() {
		return emergingTechnology;
	}
	public void setEmergingTechnology(String emergingTechnology) {
		this.emergingTechnology = emergingTechnology;
	}
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
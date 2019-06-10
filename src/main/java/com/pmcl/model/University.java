package com.pmcl.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "University")
public class University {
	@Id
	private String  id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String department;
	private String location;
	private String logo;
	private String name;
	private Integer numberOfReviews;
	private List<Review> reviews;

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public University(String name, String location, String department, String logo, Integer numberOfReviews) {
		this.setName(name);
		this.setDepartment(department);
		this.setLocation(location);
		this.setLogo(logo);
		this.setNumberOfReviews(numberOfReviews);
	}

	public void setUniversityWithouId(University university) {
		if (university.name != null)
			this.setName(university.name);
		if (university.department != null)
			this.setDepartment(university.department);
		if (university.location != null)
			this.setLocation(university.location);
		if (university.logo != null)
			this.setLogo(university.logo);
		//this.setNumberOfReviews(university.numberOfReviews);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfReviews() {
		return numberOfReviews;
	}

	public void setNumberOfReviews(Integer numberOfReviews) {
		this.numberOfReviews = numberOfReviews;
	}

	@Override
	public String toString() {
		return String.format("University[id=%s, name=%s, location=%s, departmen=%s, logo=%s, numberOfReviews=%s]",
				this.id, this.name, this.location, this.department, this.logo, this.numberOfReviews);
	}

}

package com.pmcl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Review")
public class Review {
	@Id
	private String id;

	private String universityId;
	private String role;
	private String type;
	private String context;
	private String createAt;
	private Integer numberOfReplies; 
	private List<Reply> replies;
	

	

	public Review(String universityId, String role, String type, String context, String createAt,
			Integer numberOfReplies) {
		this.universityId = universityId;
		this.role = role;
		this.type = type;
		this.context = context;
		this.createAt = createAt;
		this.numberOfReplies = numberOfReplies;
	}

	public String getId() {
		return id;
	} 

	public void setId(String id) {
		this.id = id;
	}


	public void setReviewWithoutId(Review review) {
		if (review.universityId != null)
			this.universityId = review.universityId;
		if (review.role != null)
			this.role = review.role;
		if (review.type != null)
			this.type = review.type;
		if (review.context != null)
			this.context = review.context;
		if (review.createAt != null)
			this.createAt = review.createAt;
		// if (review.role != null)
		// this.numberOfReplies = review.numberOfReplies;
	}
	public Integer getNumberOfReplies() {
		return numberOfReplies;
	}

	public void setNumberOfReplies(Integer numberOfReplies) {
		this.numberOfReplies = numberOfReplies;
	}

	public String getUniversityId() {
		return universityId;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return String.format("Review[id=%s, universityId: %s, role=%s, type=%s, context: %s, numberOfReplies=%s]",
				this.id, this.universityId, this.role, this.type, this.context, this.numberOfReplies);
	}
}

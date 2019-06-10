package com.pmcl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Reply")
public class Reply {
	@Id
	private String id;
	private String reviewId;
	private String role;
	private String type;
	private String context;
	private String createAt;

	public Reply(String reviewId, String role, String type, String context, String createAt) {
		this.reviewId = reviewId;
		this.role = role;
		this.type = type;
		this.context = context;
		this.createAt = createAt;
	} 
	public void setReplyWithoutId(Reply reply) {
		if (reply.reviewId != null)
			this.reviewId = reply.reviewId;
		if (reply.role != null)
			this.role = reply.role;
		if (reply.type != null)
			this.type = reply.type;
		if (reply.context != null)
			this.context = reply.context;
		if (reply.createAt != null)
			this.createAt = reply.createAt;
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
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
		return String.format("Reply[id=%s, reviewId: %s, role=%s, type=%s, context: %s]", this.id, this.reviewId,
				this.role, this.type, this.context);
	}
}

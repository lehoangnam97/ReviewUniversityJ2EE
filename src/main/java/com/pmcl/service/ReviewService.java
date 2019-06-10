package com.pmcl.service;

import com.pmcl.repository.ReviewRepository;
import com.pmcl.util.Helper;
 
import com.pmcl.model.Review;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;

	public Review create(Review review) {
		review.setNumberOfReplies(0); 
		review.setCreateAt(Helper.getCurrentTimeStamp());
		return reviewRepository.save(review);
	}

	public Review create(String universityId, String role, String type, String context, String createAt,
			Integer numberOfReplies) {
		return reviewRepository.save(new Review(universityId, role, type, context, Helper.getCurrentTimeStamp(), 0));
	}

	public List<Review> getAll() {
		return reviewRepository.findAll();
	}

	public List<Review> findByUniversityId(String universityId) {
		return reviewRepository.findByUniversityId(universityId);
	}
	
	public List<Review> getRecentReviews() {
		return reviewRepository.findAll();
	}

	public Review findById(ObjectId id) {
		return reviewRepository.findByObjectId(id);
	}

	public Review update(Review review) {
		return reviewRepository.save(review);
	}

	public Review update(ObjectId id, Review review) {
		Review result = reviewRepository.findByObjectId(id);
		result.setReviewWithoutId(review);
		return reviewRepository.save(result);
	}

	public Review update(ObjectId id, String universityId, String role, String type, String context, String createAt,
			Integer numberOfReplies) {
		Review review = reviewRepository.findByObjectId(id);
		review.setUniversityId(universityId);
		review.setRole(role);
		review.setType(type);
		review.setContext(context);
		// review.setCreateAt(createAt);
		// review.setNumberOfReplies(numberOfReplies);
		return reviewRepository.save(review);
	}

	public void deleteAll() {
		reviewRepository.deleteAll();
	}

	public void deleteById(ObjectId id) {
		Review Review = reviewRepository.findByObjectId(id);
		reviewRepository.delete(Review);
	}
}

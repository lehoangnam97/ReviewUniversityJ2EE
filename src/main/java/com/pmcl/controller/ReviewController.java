package com.pmcl.controller;

import java.util.HashMap;
import java.util.List;
import com.pmcl.exception.IdNotFoundException;
import com.pmcl.exception.IdNotValidException;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmcl.model.Review;
import com.pmcl.service.ReplyService;
import com.pmcl.service.ReviewService;
import com.pmcl.util.Helper;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ReplyService replyService;

	@GetMapping("/api/Reviews")
	public List<Review> getReviews() {
		return reviewService.getAll();
	}

	@GetMapping("/api/Reviews/{id}")
	public Review getReviewById(@PathVariable String id) {
		if (!ObjectId.isValid(id))
			throw new IdNotValidException(id);
		Review result = reviewService.findById(new ObjectId(id));
		if (result != null) {
			result.setReplies(replyService.findByReviewId(id));
			return result;
		} else
			throw new IdNotFoundException(id);
	}

	@GetMapping("/api/Reviews/newest")
	public List<Review> getRecentReviews() {
		return reviewService.getAll();
	}

	@PostMapping("/api/Reviews")
	public Review post(@RequestBody HashMap<String, String> requestData) {
		String role = requestData.get("role");
		String type = requestData.get("type");
		String context = requestData.get("context");
		String universityId = requestData.get("universityId");
		Review review = new Review(universityId, role, type, context, Helper.getCurrentTimeStamp(), 0);
		System.out.print("Chui vao Day");
		return reviewService.create(review);
	}

	@PutMapping("/api/Reviews/{id}")
	public Review putReview(@PathVariable String id, @RequestBody Review review) {
		if (!ObjectId.isValid(id))
			throw new IdNotValidException(id);
		if (reviewService.findById(new ObjectId(id)) != null) {
			return reviewService.update(new ObjectId(id), review);
		} else
			throw new IdNotFoundException(id);
	}

	@DeleteMapping("/api/Reviews/{id}")
	public String putReview(@PathVariable String id) {
		if (!ObjectId.isValid(id))
			throw new IdNotValidException(id);
		reviewService.deleteById(new ObjectId(id));
		return "Delete " + id + " successfully";
	}
}

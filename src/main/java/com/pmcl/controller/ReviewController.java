package com.pmcl.controller;

import java.util.List;
import com.pmcl.exception.IdNotFoundException;
import com.pmcl.exception.IdNotValidException;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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

	@PostMapping("/api/Reviews/")
	public String post(@RequestBody Review review) {
		return "Create successfully : " + reviewService.create(review).toString();
	}

	@PutMapping("/api/Reviews/{id}")
	public String putReview(@PathVariable String id, @RequestBody Review review) {
		if (!ObjectId.isValid(id))
			throw new IdNotValidException(id);
		if (reviewService.findById(new ObjectId(id)) != null) {
			return "Update successfully : " + reviewService.update(new ObjectId(id), review).toString();
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
	// 5c976a70a736ff9e2659875a
}

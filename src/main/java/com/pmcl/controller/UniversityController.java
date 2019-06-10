package com.pmcl.controller;

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
import java.util.List;

import com.pmcl.service.ReviewService;
import com.pmcl.service.UniversityService;
import com.pmcl.exception.IdNotFoundException;
import com.pmcl.exception.IdNotValidException;
import com.pmcl.model.University;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UniversityController {
	@Autowired
	private UniversityService universityService;
	@Autowired
	private ReviewService reviewService;

	@GetMapping("/api/Universities")
	public List<University> getUniversities() {
		return universityService.getAll();
	}

	@GetMapping("/api/Universities/{id}")
	public University getUniversityById(@PathVariable String id) {
		if (!ObjectId.isValid(id))
			throw new IdNotValidException(id);

		University result = universityService.findById(new ObjectId(id));
		if (result != null) {
			result.setReviews(reviewService.findByUniversityId(id));
			return result;
		} else
			throw new IdNotFoundException(id);
	}

	@PostMapping("/api/Universities/")
	public String postUniversity(@RequestBody University university) {
		return "Create successfully : " + universityService.create(university).toString();
	}

	@PutMapping("/api/Universities/{id}")
	public String putUniversity(@PathVariable String id, @RequestBody University university) {
		if (!ObjectId.isValid(id))
			throw new IdNotValidException(id);
		if (universityService.findById(new ObjectId(id)) != null) {
			return "Update successfully : " + universityService.update(new ObjectId(id), university).toString();
		} else
			throw new IdNotFoundException(id);
	}

	@DeleteMapping("/api/Universities/{id}")
	public String putUniversity(@PathVariable String id) {
		if (!ObjectId.isValid(id))
			throw new IdNotValidException(id);
		if (universityService.findById(new ObjectId(id)) != null) {
			return "Delete " + id + " successfully";
		} else
			throw new IdNotFoundException(id);

	}
}

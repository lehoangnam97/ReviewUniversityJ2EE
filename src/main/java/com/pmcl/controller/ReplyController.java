package com.pmcl.controller;

import java.util.List;

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

import com.pmcl.model.Reply;
import com.pmcl.model.Review;
import com.pmcl.service.ReplyService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ReplyController {
	@Autowired
	private ReplyService replyService;

	@GetMapping("/api/Replies")
	public List<Reply> getReplies() {
		return replyService.getAll();
	}

	@GetMapping("/api/Replies/{id}")
	public Reply getreplyById(@PathVariable String id) {
		if (!ObjectId.isValid(id))
			throw new IdNotValidException(id);
		Reply result = replyService.findById(new ObjectId(id));
		if (result != null) {
			return result;
		} else
			throw new IdNotFoundException(id);
	}

	@PostMapping("/api/Replies")
	public Reply post(@RequestBody Reply reply) {
		System.out.print("Chui vao Day");
		return replyService.create(reply);
	}

	@PutMapping("/api/Replies/{id}")
	public Reply putreply(@PathVariable String id, @RequestBody Reply reply) {
		if (!ObjectId.isValid(id))
			throw new IdNotValidException(id);
		if (replyService.findById(new ObjectId(id)) != null) {
			return replyService.update(new ObjectId(id), reply);
		} else
			throw new IdNotFoundException(id);
	}

	@DeleteMapping("/api/Replies/{id}")
	public String putreply(@PathVariable String id) {
		if (!ObjectId.isValid(id))
			throw new IdNotValidException(id);
		replyService.deleteById(new ObjectId(id));
		return "Delete " + id + " successfully";
	}
}

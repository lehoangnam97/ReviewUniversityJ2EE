package com.pmcl.service;

import com.pmcl.repository.ReplyRepository;
import com.pmcl.util.Helper;
import com.pmcl.model.Reply; 

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
	@Autowired
	private ReplyRepository replyRepository;
	
	public Reply create(Reply reply) { 
		reply.setCreateAt(Helper.getCurrentTimeStamp());
		return replyRepository.save(reply);
	}

	public Reply create(String reviewId, String role, String type, String context, String createAt) {
		return replyRepository.save(new Reply(reviewId, role, type, Helper.getCurrentTimeStamp(), createAt));
	}

	public List<Reply> getAll() {
		return replyRepository.findAll();
	}

	public Reply findById(ObjectId id) {
		return replyRepository.findByObjectId(id);
	}

	public List<Reply> findByReviewId(String reviewId) {
		return replyRepository.findByReviewId(reviewId);
	}

	public Reply update(Reply reply) {
		return replyRepository.save(reply);
	}

	public Reply update(ObjectId id, Reply reply) {
		Reply result = replyRepository.findByObjectId(id);
		result.setReplyWithoutId(reply);
		return replyRepository.save(result);
	}

	public Reply update(ObjectId id, String reviewId, String role, String type, String context, String createAt,
			Integer numberOfReplies) {
		Reply reply = replyRepository.findByObjectId(id);
		reply.setReviewId(reviewId);
		reply.setRole(role);
		reply.setType(type);
		reply.setContext(context);
		// reply.setCreateAt(createAt);
		// Reply.setNumberOfReplies(numberOfReplies);
		return replyRepository.save(reply);
	}

	public void deleteAll() {
		replyRepository.deleteAll();
	}

	public void deleteById(ObjectId id) {
		Reply Reply = replyRepository.findByObjectId(id);
		replyRepository.delete(Reply);
	}
}

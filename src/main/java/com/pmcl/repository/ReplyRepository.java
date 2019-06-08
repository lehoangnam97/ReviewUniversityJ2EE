package com.pmcl.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.pmcl.model.Reply; 

import java.util.List;

@Repository
public interface ReplyRepository extends MongoRepository<Reply, String> {
	@Query("{'_id': ?0}")
	public Reply findByObjectId(ObjectId id);
	public List<Reply> findByReviewId(String id);
	public List<Reply> findAll();
}

package com.pmcl.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.pmcl.model.Review;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
	@Query("{'_id': ?0}")
	public Review findByObjectId(ObjectId id);

	public List<Review> findByUniversityId(String universityId);

	public List<Review> findAll();
}

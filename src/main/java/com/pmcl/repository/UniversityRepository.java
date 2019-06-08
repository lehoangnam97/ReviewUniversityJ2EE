package com.pmcl.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.pmcl.model.University;
import java.util.List;

@Repository
public interface UniversityRepository extends MongoRepository<University, String> {
	@Query("{'_id': ?0}")
	public University findByObjectId(ObjectId id);

	public List<University> findAll();
}

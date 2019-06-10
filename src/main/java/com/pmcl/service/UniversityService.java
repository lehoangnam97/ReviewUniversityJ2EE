package com.pmcl.service;

import com.pmcl.repository.UniversityRepository;
import com.pmcl.model.University;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {
	@Autowired
	private UniversityRepository universityRepository;

	public University create(University university) {
		university.setNumberOfReviews(0);
		return universityRepository.save(university);
	}

	public University create(String name, String location, String department, String logo, Integer numberOfReviews) {
		return universityRepository.save(new University(name, location, department, logo, numberOfReviews));
	}

	public List<University> getAll() {
		
		return universityRepository.findAll();
	}

	public University findById(ObjectId id) {
		return universityRepository.findByObjectId(id);
	}

	public University update(University university) {
		return universityRepository.save(university);
	}

	public University update(ObjectId id, University university) {
		University result = universityRepository.findByObjectId(id);
		result.setUniversityWithouId(university);
		return universityRepository.save(result);
	}

	public University update(ObjectId id, String name, String location, String department, String logo) {
		University university = universityRepository.findByObjectId(id);
		university.setName(name);
		university.setLocation(location);
		university.setDepartment(department);
		university.setLogo(logo);
		return universityRepository.save(university);
	}

	public void deleteAll() {
		universityRepository.deleteAll();
	}

	public void deleteById(ObjectId id) {
		University university = universityRepository.findByObjectId(id);
		universityRepository.delete(university);
	}
}

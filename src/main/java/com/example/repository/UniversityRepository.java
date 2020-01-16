package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.UniversityEntity;

@Repository
public interface UniversityRepository  extends JpaRepository<UniversityEntity, Integer>{

	
	@Query("select universityName from UniversityEntity")
	public List<String> getAllUniversities();
}

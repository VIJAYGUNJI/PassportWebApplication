package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.DegreesEntity;
@Repository
public interface DegreesRepository extends JpaRepository<DegreesEntity, Integer> {
	
	@Query("select degreename from DegreesEntity")
	public List<String> getallDegrees();

}

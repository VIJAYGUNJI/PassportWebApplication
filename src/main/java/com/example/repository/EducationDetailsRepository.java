package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.EducationDetailsEntity;

@Repository
public interface EducationDetailsRepository extends JpaRepository<EducationDetailsEntity, Integer> {

}

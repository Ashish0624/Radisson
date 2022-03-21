package com.myworkspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myworkspace.model.MasterSurveyType;

@Repository
public interface SurveyTypeRepository 
	extends 
	JpaRepository<MasterSurveyType, Integer> {

}

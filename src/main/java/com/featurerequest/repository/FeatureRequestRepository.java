package com.featurerequest.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.featurerequest.entity.FeatureRequest;

@Repository
public interface FeatureRequestRepository extends JpaRepository<FeatureRequest, Long>{
	
	
	List<FeatureRequest> findByClientAndClientPriorityGreaterThanEqualOrderByClientPriority(String client,int priority);

}
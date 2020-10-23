package com.featurerequest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.featurerequest.controller.modal.FeatureRequestData;
import com.featurerequest.entity.FeatureRequest;
import com.featurerequest.repository.FeatureRequestRepository;

@Service
public class FeatureRequestService implements IFeatureRequestService {

	@Autowired
	FeatureRequestRepository featureRequestRepository;

	@Override
	public List<FeatureRequestData> getAllFeatureRequests() {
		List<FeatureRequest> featureRequests = featureRequestRepository.findAll();
		List<FeatureRequestData> featureRequestDataList = new ArrayList<>();
		featureRequests.forEach(featureRequest -> {
			featureRequestDataList.add(toData(featureRequest));
		});
		return featureRequestDataList;
	}

	@Override
	public List<FeatureRequestData> saveFeatureRequest(FeatureRequestData featureRequestData) {
		List<FeatureRequest> featureRequests = featureRequestRepository.
				findByClientAndClientPriorityGreaterThanEqualOrderByClientPriority(featureRequestData.getClient(),
						featureRequestData.getClientPriority());
		if (featureRequests.size() == 0 || featureRequests.get(0).getClientPriority() != featureRequestData.getClientPriority()) {
			featureRequestRepository.save(fromData(featureRequestData));
		} else  {
			featureRequests.forEach(featureRequest -> {
				featureRequest.setClientPriority(featureRequest.getClientPriority() + 1);
				featureRequestRepository.save(featureRequest);
			});
			featureRequestRepository.save(fromData(featureRequestData));
		}
		return getAllFeatureRequests();
	}

	private FeatureRequestData toData(FeatureRequest featureRequest) {
		FeatureRequestData featureRequestData = new FeatureRequestData();
		featureRequestData.setClient(featureRequest.getClient());
		featureRequestData.setClientPriority(featureRequest.getClientPriority());
		featureRequestData.setDescription(featureRequest.getDescription());
		featureRequestData.setId(featureRequest.getId());
		featureRequestData.setProductArea(featureRequest.getProductArea());
		featureRequestData.setTargetDate(featureRequest.getTargetDate());
		featureRequestData.setTitle(featureRequest.getTitle());
		return featureRequestData;
	}

	private FeatureRequest fromData(FeatureRequestData featureRequestData) {
		FeatureRequest featureRequest = new FeatureRequest();
		featureRequest.setClient(featureRequestData.getClient());
		featureRequest.setClientPriority(featureRequestData.getClientPriority());
		featureRequest.setDescription(featureRequestData.getDescription());
		featureRequest.setProductArea(featureRequestData.getProductArea());
		featureRequest.setTargetDate(featureRequestData.getTargetDate());
		featureRequest.setTitle(featureRequestData.getTitle());
		return featureRequest;
	}

}

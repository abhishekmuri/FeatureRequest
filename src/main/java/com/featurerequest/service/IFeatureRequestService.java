package com.featurerequest.service;

import java.util.List;

import com.featurerequest.controller.modal.FeatureRequestData;

public interface IFeatureRequestService {
	List<FeatureRequestData> getAllFeatureRequests();
	List<FeatureRequestData> saveFeatureRequest(FeatureRequestData featureRequestData) throws Exception;
}

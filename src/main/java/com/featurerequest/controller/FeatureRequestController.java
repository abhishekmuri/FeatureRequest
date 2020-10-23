package com.featurerequest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.featurerequest.controller.modal.FeatureRequestData;
import com.featurerequest.service.IFeatureRequestService;

@RestController
@RequestMapping("/api/v1")
public class FeatureRequestController {
	@Autowired
	private IFeatureRequestService featureRequestService;

	@GetMapping("/featurerequests")
	public List<FeatureRequestData> getAllFeatureRequests() {
		return featureRequestService.getAllFeatureRequests();
	}

	@PostMapping("/featurerequest")
	public List<FeatureRequestData> createFeatureRequest(@RequestBody FeatureRequestData featureRequestData) throws Exception {
		return featureRequestService.saveFeatureRequest(featureRequestData);
	}
}
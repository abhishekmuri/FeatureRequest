package com.featurerequest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.annotation.RequestBody;

import com.featurerequest.controller.modal.FeatureRequestData;
import com.featurerequest.entity.FeatureRequest;
import com.featurerequest.repository.FeatureRequestRepository;
import com.featurerequest.service.FeatureRequestService;

public class FeatureRequestControllerTest {

	private FeatureRequestService featureRequestService;
	
	@InjectMocks
	@Resource
	private FeatureRequestController featureRequestController;
	
	@BeforeEach
	public void setup() throws Exception {
		featureRequestService = Mockito.mock(FeatureRequestService.class);
		MockitoAnnotations.initMocks(this);
		featureRequestController = new FeatureRequestController();
		MockitoAnnotations.initMocks(this);
		List<FeatureRequestData> featureRequests = new ArrayList<>();
		featureRequests.add(new FeatureRequestData());
		Mockito.when(featureRequestService.getAllFeatureRequests()).thenReturn(featureRequests);
		Mockito.when(featureRequestService.saveFeatureRequest(Mockito.any(FeatureRequestData.class))).thenReturn(featureRequests);
	}

	@Test
	public void test_GetAllFeatureRequests() {
		List<FeatureRequestData> featureRequestDataList = featureRequestController.getAllFeatureRequests();
		assertEquals(1, featureRequestDataList.size());
		assertEquals(null, featureRequestDataList.get(0).getClient());
	}
	
	@Test
	public void test_createFeatureRequest() throws Exception {
		List<FeatureRequestData> featureRequestDataList = featureRequestController.createFeatureRequest(new FeatureRequestData());
		assertEquals(1, featureRequestDataList.size());
		assertEquals(null, featureRequestDataList.get(0).getClient());
	}

}
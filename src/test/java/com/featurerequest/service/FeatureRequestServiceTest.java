package com.featurerequest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.featurerequest.controller.modal.FeatureRequestData;
import com.featurerequest.entity.FeatureRequest;
import com.featurerequest.repository.FeatureRequestRepository;

public class FeatureRequestServiceTest {

	FeatureRequestRepository featureRequestRepository;

	@InjectMocks
	@Resource
	FeatureRequestService service = new FeatureRequestService();

	@BeforeEach
	public void setup() {
		featureRequestRepository = Mockito.mock(FeatureRequestRepository.class);
		MockitoAnnotations.initMocks(this);
		List<FeatureRequest> featureRequests = new ArrayList<>();
		featureRequests.add(new FeatureRequest());
		Mockito.when(featureRequestRepository.findAll()).thenReturn(featureRequests);
		Mockito.when(featureRequestRepository.save(Mockito.any(FeatureRequest.class))).thenReturn(new FeatureRequest());
	}

	@Test
	public void test_getAllFeatureRequests() {
		List<FeatureRequestData> featureRequestDataList = service.getAllFeatureRequests();
		assertEquals(1, featureRequestDataList.size());
		assertEquals(null, featureRequestDataList.get(0).getClient());
	}
	
	public void test_saveFeatureRequest() throws Exception {
		List<FeatureRequestData> featureRequestDataList = service.saveFeatureRequest(new FeatureRequestData());
		assertEquals(1, featureRequestDataList.size());
		assertEquals(null, featureRequestDataList.get(0).getClient());
	}

}

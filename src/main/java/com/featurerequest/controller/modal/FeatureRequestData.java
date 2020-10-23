package com.featurerequest.controller.modal;

import java.util.Date;

public class FeatureRequestData {
	private long id;
	private String title;
	private String description;
	private String client;
	private int clientPriority;
	private Date targetDate;
	private String productArea;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public int getClientPriority() {
		return clientPriority;
	}

	public void setClientPriority(int clientPriority) {
		this.clientPriority = clientPriority;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getProductArea() {
		return productArea;
	}

	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}

	@Override
	public String toString() {
		return "FeatureRequestData [id=" + id + ", title=" + title + ", description=" + description + ", client="
				+ client + ", clientPriority=" + clientPriority + ", targetDate=" + targetDate + ", productArea="
				+ productArea + "]";
	}

}

package com.apap.tutorial4.service;

import com.apap.tutorial4.model.PilotModel;

public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber(String lincenseNumber);
	
	void addPilot(PilotModel pilot);
	void deletePilot(Long id);
	void updatePilot(PilotModel pilot, String licenseNumber);
}

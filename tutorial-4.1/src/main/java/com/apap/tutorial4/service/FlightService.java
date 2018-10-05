package com.apap.tutorial4.service;

import com.apap.tutorial4.model.FlightModel;

public interface FlightService {
	FlightModel getFlightDetailById(Long id);
	void addFlight(FlightModel flight);
	void deleteFlight(Long id);
	void updateFlight(FlightModel newFlight, Long id);
}

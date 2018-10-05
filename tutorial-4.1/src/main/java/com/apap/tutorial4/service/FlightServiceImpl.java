package com.apap.tutorial4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.repository.FlightDb;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDb flightDb;
	
	@Override
	public FlightModel getFlightDetailById(Long id) {
		return flightDb.findById(id).get();
	}
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}

	@Override
	public void deleteFlight(Long id) {
		flightDb.deleteById(id);
		
	}

	@Override
	public void updateFlight(FlightModel newFlight, Long id) {
		FlightModel flight = flightDb.findById(id).get();
		flight.setDestination(newFlight.getDestination());
		flight.setFlightNumber(newFlight.getFlightNumber());
		flight.setOrigin(newFlight.getOrigin());
		flight.setTime(newFlight.getTime());
		
	}



}

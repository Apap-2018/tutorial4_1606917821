package com.apap.tutorial4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.service.PilotService;

@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		return "addPilot";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "add";
	}
	
	@RequestMapping(value = "/pilot/view-pilot", method = RequestMethod.GET)
	private String viewPilotByLicenseNumber(@RequestParam("licenseNumber") String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		List<FlightModel> pilotFlight = pilot.getPilotFlight();
		model.addAttribute("flightList",pilotFlight);
		model.addAttribute("pilot", pilot);
		
		if(pilotFlight == null) {
			return "error";
		}else {
			return "view-pilot";
		}
			
	}
	
	@RequestMapping(value = "/pilot/delete/{id}", method = RequestMethod.GET)
	private String deletePilot(@PathVariable(value="id") Long id, Model model) {
		pilotService.deletePilot(id);
		return "delete";
	}
	
	@RequestMapping(value = "/pilot/update/{licenseNumber}", method = RequestMethod.GET)
	private String update(@PathVariable(value="licenseNumber") String licenseNumber, Model model) {
		PilotModel pilotToUpdate = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilot", pilotToUpdate);
		return "updatePilot";
	}
	
	@RequestMapping(value = "/pilot/update/", method = RequestMethod.POST)
	private String updatePilotSubmit(@PathVariable(value="licenseNumber") String licenseNumber, @ModelAttribute PilotModel pilot) {
		pilotService.updatePilot(pilot, licenseNumber);
		return "update";
	}
	
	
	
	
}

package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DisasterSummaries;
import com.example.demo.service.DisasterService;

@RestController
public class DisasterContoller {
	@Autowired
	private DisasterService disasterService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/v1/findAll")
	public String getDisasterSummary()throws IOException {
		return disasterService.getDisasterSummaries();
	}
	@RequestMapping(method=RequestMethod.GET, value="/api/v1/findByType")
	public DisasterSummaries getDisasterByType(@RequestParam (required=true)String disasterType) throws IOException{
		return disasterService.getDistrSmryByType(disasterType);
	}
	
}

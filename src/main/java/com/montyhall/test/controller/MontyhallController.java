package com.montyhall.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.montyhall.test.business.MontyhallGameSimulator;
import com.montyhall.test.business.MontyhallResultDTO;

@RestController
public class MontyhallController {
	
	@Autowired
	private MontyhallGameSimulator gameSimulator;
	
	@PostMapping(path = "/api/play/{iterations}/{switchSelection}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MontyhallResultDTO> gameResult(@PathVariable int iterations, @PathVariable boolean switchSelection) {
		
		if (iterations <= 1000) {
			return gameSimulator.runIterations(iterations, switchSelection);
		} else {
			return gameSimulator.getWinPercentage(iterations, switchSelection);
		}
		
	}

}

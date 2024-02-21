package com.rapidraider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rapidraider.Entity.RegisterTour;
import com.rapidraider.services.RegisterService;

@RestController
@CrossOrigin
@RequestMapping("/regicontroller")
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	
	//Adding data to database 
	@PostMapping("/registersave")
	public ResponseEntity<RegisterTour> addRegisterTour(@RequestBody RegisterTour registerTour){		
		RegisterTour regiSave= registerService.addRegisterTour(registerTour);
		return new ResponseEntity<RegisterTour>(regiSave,HttpStatus.CREATED);
	}
	//Getting all data from database
	@GetMapping("/allregitour")
	public ResponseEntity<List<RegisterTour>> getAllRegisterTour(){
		List<RegisterTour> ListRegiTour=registerService.getAllRegisterTour();
		return new ResponseEntity<List<RegisterTour>>(ListRegiTour,HttpStatus.OK);
	}
	// get data by ID 
	@GetMapping("/getregiID/{regiID}")
	public ResponseEntity<RegisterTour> getRegisterTourById(@PathVariable("regiID") int regiID){
		RegisterTour registerTour=registerService.getRegisterTourById(regiID);
		return new ResponseEntity<RegisterTour>(registerTour, HttpStatus.OK);
	}
	@GetMapping("/getregiloc/{regiloc}")
    public ResponseEntity<List<RegisterTour>> getRegisterTourByLocation(@PathVariable("regiloc") String locationValue) {
        List<RegisterTour> registerTour = registerService.findByLocationValue(locationValue);
        return new ResponseEntity<>(registerTour, HttpStatus.OK);
    }

	// Delete data by ID
	@DeleteMapping("/deleteregiID/{regiID}")
	public ResponseEntity<Void> deleteRegitourById(@PathVariable("regiID") int regiID) {
		registerService.deleteRegitourById(regiID);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	//Updating data 
	@PutMapping("/updateRegitour")
	public ResponseEntity<RegisterTour> updateRegisterTour(@RequestBody RegisterTour registerTour){
		RegisterTour regiTourUpdate=registerService.addRegisterTour(registerTour);
		return new ResponseEntity<RegisterTour>(regiTourUpdate,HttpStatus.OK);
	}
}

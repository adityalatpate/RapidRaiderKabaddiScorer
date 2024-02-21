package com.rapidraider.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.rapidraider.Entity.RegisterTour;
import com.rapidraider.exception.EmptyInputException;
import com.rapidraider.repository.RegisterRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class RegisterServiceImpl implements RegisterService{
	private static final Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);
	
	@Autowired
	public RegisterRepository registerRepository;

	@Override
	public RegisterTour addRegisterTour(RegisterTour registerTour) {
		logger.info("RegisterTour Service Implementation : save() method");
		RegisterTour regiTour=registerRepository.save(registerTour);
		return regiTour;
	}

	@Override
	public List<RegisterTour> getAllRegisterTour() {
		logger.info("RegisterTour Service Implementation : findAll() method");
		List<RegisterTour> regiList=null;
		regiList=registerRepository.findAll();
		if(regiList.isEmpty()) {
			throw new EmptyInputException("602","Hey list is empty");
		}
		return regiList;
	}

	/*
	 * @Override public RegisterTour getRegisterTourById(long regiID) {
	 * logger.info("RegisterTour Service Implementation : findById() method");
	 * return registerRepository.findById(regiID).get();
	 * 
	 * }
	 */
	@Override
	public RegisterTour getRegisterTourById(long regiID) {
		
		return registerRepository.findById(regiID)
                .orElseThrow(() -> new EntityNotFoundException("Tournament not found with id: " + regiID));
	}
	
	@Override
	public void deleteRegitourById(long regiID) {
		logger.info("RegisterTour Service Implementation : deleteById() method");
		registerRepository.deleteById(regiID);
		
	}


	
	
	 @Transactional
	  
	  @Override public void deleteOldData() { LocalDate oneYearAgo =
	  LocalDate.now().minusYears(1); registerRepository.deleteOldData(oneYearAgo);
	  
	  }
	 

	@Override
	public List<RegisterTour> findByLocationVenue(String locationVenue) {
		return registerRepository.findByLocationVenue(locationVenue);
	
	}

	

	

/*Logging in Spring Boot plays a vital role in Spring Boot applications
	for recording information, actions, and events within the app.
	It is also used for monitoring the performance of an application,
	understanding the behavior of the application, and recognizing the
issues within the application*/

	

	

	

}

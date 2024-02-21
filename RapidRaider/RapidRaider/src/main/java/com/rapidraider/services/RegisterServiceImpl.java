package com.rapidraider.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rapidraider.Entity.RegisterTour;
import com.rapidraider.exception.EmptyInputException;
import com.rapidraider.repository.RegisterRepository;

@Service
public class RegisterServiceImpl implements RegisterService{
	@Autowired
	public RegisterRepository registerRepository;

	@Override
	public RegisterTour addRegisterTour(RegisterTour registerTour) {		
		RegisterTour regiTour=registerRepository.save(registerTour);
		return regiTour;
	}

	@Override
	public List<RegisterTour> getAllRegisterTour() {
		
		List<RegisterTour> regiList=null;
		regiList=registerRepository.findAll();
		if(regiList.isEmpty()) {
			throw new EmptyInputException("602","Hey list is empty");
		}
		return regiList;
	}

	@Override
	public RegisterTour getRegisterTourById(long regiID) {
		return registerRepository.findById(regiID).get();
	
	}

	@Override
	public void deleteRegitourById(long regiID) {
		registerRepository.deleteById(regiID);
		
	}

	@Override
	public List<RegisterTour> findByLocationValue(String locationValue) {
		
		return registerRepository.findByLocationValue(locationValue);
	}

	

	

	

	

	

}

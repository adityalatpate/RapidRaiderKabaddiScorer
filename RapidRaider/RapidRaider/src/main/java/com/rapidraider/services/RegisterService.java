package com.rapidraider.services;

import java.util.List;

import com.rapidraider.Entity.RegisterTour;

public interface RegisterService {

public	RegisterTour addRegisterTour(RegisterTour registerTour);

public List<RegisterTour> getAllRegisterTour();

public RegisterTour getRegisterTourById(long regiID);

public void deleteRegitourById(long regiID);

public List<RegisterTour> findByLocationValue(String locationValue);




	


}

package com.rapidraider.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rapidraider.Entity.RegisterTour;
@Repository
public interface RegisterRepository extends JpaRepository<RegisterTour,Long>{

	List<RegisterTour> findByLocationValue(String locationValue);

}
//for custom findByLocationValue we have to use Spring data jpa
/*Spring Data JPA will automatically generate the query to search for RegisterTour entities by locationValue,
and we can use this method to retrieve entities based on the specified location.*/
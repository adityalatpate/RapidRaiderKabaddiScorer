package com.rapidraider.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rapidraider.Entity.RegisterTour;
import com.rapidraider.Entity.Team;
import com.rapidraider.repository.RegisterRepository;
import com.rapidraider.repository.TeamRepository;

public class TeamServiceImpl implements TeamService{
	
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private RegisterService registerService;
	
	

	@Override
	public void addTeamToTournament(Team team, RegisterTour tournament) {
		 boolean teamExists = teamRepository.existsByTeamNameAndTournament(team.getTeamName(), tournament);
	        if (teamExists) {
	            throw new IllegalArgumentException("Team already exists in the tournament.");
	        }
	        team.setTournament(tournament);
	        teamRepository.save(team);
		
	}



	@Override
	public List<Team> getAllTeamsByTournament(Long tournamentId) {
		RegisterTour tournament = registerService.getRegisterTourById(tournamentId);
        return teamRepository.findAllByTournament(tournament);
	}

	
}

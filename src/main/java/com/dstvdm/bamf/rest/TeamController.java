package com.dstvdm.bamf.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dstvdm.bamf.model.Person;
import com.dstvdm.bamf.model.Team;
import com.dstvdm.bamf.repository.TeamRepository;

@RestController
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	private TeamRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
    public List<Team> findAllTeams() {
        return repository.findAll();
    }
	
	@RequestMapping("/findByTeamName")
    public List<Team> findByTeamName(@RequestParam String teamName) {
        return repository.findByTeamName(teamName);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public Team addTeam(@RequestBody Team team) {
        return repository.save(team);
    }

}

package com.dstvdm.bamf.rest;

import com.dstvdm.bamf.model.Person;
import com.dstvdm.bamf.model.Team;
import com.dstvdm.bamf.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by pscot on 3/2/2016.
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> findAllPersons() {
        return repository.findAll();
    }

    @RequestMapping("/findByFirstName")
    public List<Person> findByFirstName(@RequestParam String firstName) {
        return repository.findByFirstName(firstName);
    }

    @RequestMapping("/findByLastName")
    public List<Person> findByLastName(@RequestParam String lastName) {
        return repository.findByLastName(lastName);
    }

    @RequestMapping("/findByTeam")
    public List<Person> findByAge(@RequestParam Team team) {
        return repository.findByTeam(team);
    }


}
package com.dstvdm.bamf.repository;

/**
 * Created by pscot on 3/2/2016.
 */

import com.dstvdm.bamf.model.Person;
import com.dstvdm.bamf.model.Team;
import org.springframework.data.orient.commons.repository.annotation.Query;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

import java.util.List;

public interface PersonRepository extends OrientObjectRepository<Person> {

    List<Person> findByFirstName(String firstName);

    @Query("select from person where lastName = ?")
    List<Person> findByLastName(String lastName);

    List<Person> findByTeam(Team team);
}
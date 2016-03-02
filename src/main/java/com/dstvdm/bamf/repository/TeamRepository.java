package com.dstvdm.bamf.repository;

import com.dstvdm.bamf.model.Team;
import org.springframework.data.orient.commons.repository.annotation.Query;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

import java.util.List;

/**
 * Created by pscot on 3/2/2016.
 */
public interface TeamRepository extends OrientObjectRepository<Team> {

    List<Team> findByTeamName(String teamName);

    @Query("select from person where teamName = ?")
    List<Team> findByTeamNames(String teamName);
}
package com.dstvdm.bamf.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.orientechnologies.orient.core.annotation.OId;
import com.orientechnologies.orient.core.annotation.OVersion;

import java.util.List;

/**
 * Created by pscot on 3/2/2016.
 */
@JsonIgnoreProperties("handler")
public class Team {

    @OId
    private String id;

    @OVersion
    private Long version;

    private String teamName;

    private String teamDescription;

    private List<Person> teamMembers;

    private Location teamLocation;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }

    public List<Person> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Person> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public Location getTeamLocation() {
        return teamLocation;
    }

    public void setTeamLocation(Location teamLocation) {
        this.teamLocation = teamLocation;
    }
}

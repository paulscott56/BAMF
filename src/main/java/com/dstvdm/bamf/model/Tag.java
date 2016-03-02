package com.dstvdm.bamf.model;

/**
 * Created by pscot on 3/2/2016.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.orientechnologies.orient.core.annotation.OId;
import com.orientechnologies.orient.core.annotation.OVersion;

import java.util.List;

@JsonIgnoreProperties("handler")
public class Tag {

    @OId
    private String id;

    @OVersion
    private Long version;

    private String name;

    private List<Note> notes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }


}
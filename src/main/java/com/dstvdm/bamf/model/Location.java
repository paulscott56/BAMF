package com.dstvdm.bamf.model;

import com.orientechnologies.orient.core.annotation.OId;
import com.orientechnologies.orient.core.annotation.OVersion;

/**
 * Created by pscot on 3/2/2016.
 */
public class Location {

    @OId
    private String id;

    @OVersion
    private Long version;

    private String latitude;

    private String longitude;

    private String locationDescription;

    private String company;

    private Person manager;
}

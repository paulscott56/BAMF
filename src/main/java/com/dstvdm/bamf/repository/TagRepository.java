package com.dstvdm.bamf.repository;

import com.dstvdm.bamf.model.Tag;
import org.springframework.data.orient.commons.repository.annotation.Query;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

import java.util.List;

/**
 * Created by pscot on 3/2/2016.
 */
public interface TagRepository extends OrientObjectRepository<Tag> {

    List<Tag> findByName(String name);

    @Query("select from tag where name = ?")
    List<Tag> findTagName(String name);
}
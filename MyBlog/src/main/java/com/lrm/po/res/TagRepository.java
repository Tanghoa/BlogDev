package com.lrm.po.res;

import com.lrm.po.Tag;

import org.springframework.data.jpa.repository.JpaRepository;



/**
 * Created by limi on 2017/10/16.
 */
public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findByName(String name);






}

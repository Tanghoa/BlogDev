package com.lrm.service;

import com.lrm.entity.Type;

import java.util.List;

public interface TypeSerice {

    List<Type> getTypes();


    Type getType(Long id);
}

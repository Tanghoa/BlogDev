package com.lrm.service.impl;

import com.lrm.entity.Type;
import com.lrm.mapper.TypeMapper;
import com.lrm.service.TypeSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeSeriveimpl implements TypeSerice {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> getTypes() {
        return typeMapper.getAllType();
    }

    @Override
    public Type getType(Long id) {
        return typeMapper.selectByPrimaryKey(id);
    }
}

package com.lrm.service;

import com.lrm.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAll();

    List<Tag> getTagByString(String text);

}

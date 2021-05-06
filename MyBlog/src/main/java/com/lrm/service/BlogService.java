package com.lrm.service;


import com.lrm.entity.Blog;

import java.util.List;

public interface BlogService {

    List<Blog> getAllBlogs();

    int saveBlog(Blog blog);


    void updateBlog(Blog blog);

    Blog getBlogs(Long id);
}

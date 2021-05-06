package com.lrm.service.impl;

import com.lrm.entity.Blog;
import com.lrm.entity.BlogAndTag;
import com.lrm.entity.BlogWithBLOBs;
import com.lrm.entity.Tag;
import com.lrm.mapper.BlogMapper;
import com.lrm.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceimpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Blog> getAllBlogs() {
        return blogMapper.getAllBlogs();
    }

    @Override
    public int saveBlog(Blog blog) {


        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        //保存博客
//        blogMapper.insert((BlogWithBLOBs) blog);
        blogMapper.saveBlog(blog);
        //保存博客后才能获取自增的id
        Long id = blog.getId();
        //将标签的数据存到t_blogs_tag表中
        List<Tag> tags = blog.getTags();
        BlogAndTag blogAndTag = null;
        for (Tag tag : tags) {
            //新增时无法获取自增的id,在mybatis里修改
            blogAndTag = new BlogAndTag(tag.getId(), id);
            blogMapper.saveBlogAndTag(blogAndTag);
        }
        return 1;

    }

    @Override
    public void updateBlog(Blog blog) {

    }

    @Override
    public Blog getBlogs(Long id) {

        return blogMapper.selectByPrimaryKey(id);

    }


}

package com.lrm.controller;

import com.lrm.entity.Blog;
import com.lrm.entity.Type;
import com.lrm.entity.User;
import com.lrm.service.impl.AdminServiceimpl;
import com.lrm.service.impl.BlogServiceimpl;
import com.lrm.service.impl.TagSeviceimpl;
import com.lrm.service.impl.TypeSeriveimpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class BlogContorller {



    @Autowired
    private AdminServiceimpl adminService;


    @Autowired
    private BlogServiceimpl blogService;


    @Autowired
    private TagSeviceimpl tagService;

    @Autowired
    private TypeSeriveimpl typeService;

    public void setTypeAndTag(Model model) {
        model.addAttribute("types", typeService.getTypes());
        model.addAttribute("tags", tagService.getAll());
    }

    public String getBlogs(){
        return  null;
    }

    @GetMapping("/blogs/input") //去新增博客页面
    public String toAddBlog(Model model){
        model.addAttribute("blog", new Blog());  //返回一个blog对象给前端th:object
        setTypeAndTag(model);
        return "admin/blogs-input";
    }

//    /admin/blogs/{id}/input(id=${blog.id}
    @GetMapping("/blogs/{id}/input") //去编辑博客页面
    public String toEditBlog(@PathVariable Long id, Model model){
        Blog blog = blogService.getBlogs(id);
        Type type = typeService.getType(blog.getTypeId());
        blog.setType(type);
        blog.init();   //将tags集合转换为tagIds字符串
        model.addAttribute("blog", blog);     //返回一个blog对象给前端th:object
        setTypeAndTag(model);
        return "admin/blogs-input";
    }

    @PostMapping("/blogs")
    public String gettoSave(Blog blog, Model model, HttpSession session,
                            RedirectAttributes attributes){


        blog.setUser((User) session.getAttribute("user"));
        blog.setUserId(blog.getUser().getId());

        System.out.println("typeId:"+blog.getType().getId());

        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTypeId(blog.getType().getId());

        blog.setTags(tagService.getTagByString(blog.getTagIds()));

        if (blog.getId() == null) {   //id为空，则为新增
            blogService.saveBlog(blog);
        } else {
            blogService.updateBlog(blog);
        }

        attributes.addFlashAttribute("msg", "新增成功");
        return "redirect:/admin/blogs";

    }


}

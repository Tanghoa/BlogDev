package com.lrm.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrm.JPAservice.TagServiceImpl;
import com.lrm.entity.Blog;
import com.lrm.entity.User;
import com.lrm.service.impl.AdminServiceimpl;
import com.lrm.service.impl.BlogServiceimpl;
import com.lrm.service.impl.TagSeviceimpl;
import com.lrm.service.impl.TypeSeriveimpl;
import com.lrm.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.GeneratedValue;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceimpl userService;

    @Autowired
    private BlogServiceimpl blogService;


    @Autowired
    private TagSeviceimpl tagService;

    @Autowired
    private TypeSeriveimpl typeService;

    @GetMapping
    public String loginPage() {
        return "admin/login";
    }


    @GetMapping("/login")
    public String login(HttpSession session){
        if (session.getAttribute("user")!=null) return "admin/index";
        else return "redirect:/admin";
    }


    public void setTypeAndTag(Model model) {
        model.addAttribute("types", typeService.getTypes());
        model.addAttribute("tags", tagService.getAll());
    }


   @GetMapping("/blogs")
    public String loginPage(@RequestParam(required = false,defaultValue = "1",value = "pagenum")int pagenum,
                            Model model){

       PageHelper.startPage(pagenum, 5);
       List<Blog> blogs = blogService.getAllBlogs();

       PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
       model.addAttribute("pageInfo",pageInfo);
       setTypeAndTag(model);
       return "admin/blogs";
    }


    @RequestMapping("/login")
    public String login(
            @RequestParam("username") String username
            , @RequestParam("password") String password,
            HttpSession session,
            RedirectAttributes attributes)
    {
        String code = MD5Utils.code(password);
        User user = userService.checkLogin(username, code);
        if(user!=null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "/admin/index";
        }
        attributes.addFlashAttribute("message", "用户名和密码错误");
        System.out.println("error failed login");
         return   "redirect:/admin";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }




}

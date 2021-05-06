package com.lrm.controller.Test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class TestController {

    @GetMapping("/input")
    public  String  getinput(Model model){
        model.addAttribute("type",new Demp());
        return "TestNoBlank";
    }


    @RequestMapping("/test")
    public String check(@Validated Demp demp , BindingResult result){
        if (result.hasErrors()){
            System.out.println("error");
            return "TestNoBlank";
        }

        return "testinput";
    }




}

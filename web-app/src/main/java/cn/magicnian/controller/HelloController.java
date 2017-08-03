package cn.magicnian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.magicnian.service.SimpleService;

/**
 * Created by liunn on 2017/5/19.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private SimpleService simpleService;


    @RequestMapping("/demo/{userid}")
    public String hello(Model model,@PathVariable("userid") Integer id){
        String name = simpleService.getUserName(id);
        model.addAttribute("name",name);
        return "hello";
    }

}

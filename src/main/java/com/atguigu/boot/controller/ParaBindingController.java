package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import com.atguigu.boot.bean.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class ParaBindingController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @PostMapping("/saveUser")
    public Person saveUser(Person person){
        return person;
    }

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params){
        Map<String,Object> map = new HashMap<>();
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        return map;
    }

    @RequestMapping("/test")
    public String Mapping(Model model){
        model.addAttribute("key","val");
        return "forward:/page";
    }

    @RequestMapping("/test1")
    public String toTest(){
        int i = 1/0;
        System.out.println("toTest!!");
        return "test";
    }

    @ResponseBody
    @RequestMapping("/page")
    public String page(HttpServletRequest request){

        return (String)request.getAttribute("key");
    }

    @RequestMapping("/sql")
    @ResponseBody
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_emp", Long.class);
        return aLong.toString();
    }
}

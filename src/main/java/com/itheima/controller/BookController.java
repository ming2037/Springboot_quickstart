package com.itheima.controller;

import com.itheima.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    /**
     * Whitelabel Error Page
     *
     * This application has no explicit mapping for /error, so you are seeing this as a fallback.
     *
     * Mon Jun 24 14:56:23 CST 2019
     *
     * There was an unexpected error (type=Not Found, status=404).
     *
     * No message available
     *IDEA目录结构的问题，
     * Application启动类的位置不对.
     * 要将Application类放在最外侧,
     * 即包含所有子包 。
     */
    @Value("${name}")
    private String name;
    @Value("${server.port}")
    private Integer port;
    @Value("${student.hobbies[0]}")
    private String hobby;//数组如何装入

    //配置环境，自动全部装入
    @Autowired
    private Environment environment;

    @Autowired
    private Student student;

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){

        System.out.println("id ==> "+id);
        System.out.println("name ==>" + name);
        System.out.println("port ==>" + port);
        System.out.println("hobby ==>"+hobby);
        //通过装入整体环境，使用环境去拿里面的变量
        System.out.println(environment.getProperty("name"));
        System.out.println(environment.getProperty("student.name"));
        System.out.println("-------------");
        System.out.println(student);
        return "Hello SpringBoot!";
    };
    @RequestMapping("/hello")
    public String Hello(){
        System.out.println("Hello SpringBoot!");
        return "Hello SpringBoot!";
    }
}

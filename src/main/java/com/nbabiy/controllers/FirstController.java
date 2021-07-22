package com.nbabiy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author nazariibabii
 */
@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname) {
//        @RequestParam throws 400 BadRequest if one or more params are not exits
//        but you can use required param of that annotation to make params not required

//        You can use HttpServletRequest as argument and spring autowire it
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");

        System.out.println("Hello, " + name + " " + surname );

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}

package com.nbabiy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author nazariibabii
 */
@Controller
public class HelloController {

    @GetMapping("/exit")
    public String exit() {
        return "second/exit";
    }
}

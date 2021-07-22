package com.nbabiy.controllers;

import com.nbabiy.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author nazariibabii
 */
@Controller
@RequestMapping("/first")
public class CalculatorController {

    private CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam(name = "a") int a,
                            @RequestParam(name = "b") int b,
                            @RequestParam(name = "action") String action,
                            Model model) {

        switch (action) {
            case "add":
                model.addAttribute("result", calculatorService.add(a, b));
                break;
            case "sub":
                model.addAttribute("result", calculatorService.sub(a, b));
                break;
            case "mul":
                model.addAttribute("result", calculatorService.mul(a, b));
                break;
            case "div":
                model.addAttribute("result", calculatorService.div(a, b));
                break;
            default:
                model.addAttribute("result", "Method does not exist");
        }

        return "first/calculator";
    }

}

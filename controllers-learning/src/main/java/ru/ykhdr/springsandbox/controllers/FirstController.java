package ru.ykhdr.springsandbox.controllers;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        model.addAttribute("message", "Hello, " + name + " " + surname + "!");

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }


    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a") int a,
                             @RequestParam(value = "b") int b,
                             @RequestParam(value = "action") String action,
                             Model model) {
        model.addAttribute("result",
                switch (action) {
                    case "multiplication" -> a * b;
                    case "addition" -> a + b;
                    case "subtraction" -> a - b;
                    case "division" -> a / b;
                    default -> "Unknown action was passed";
                });

        return "first/calculator";
    }
}

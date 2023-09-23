package ru.ykhdr.securityproject.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ykhdr.securityproject.models.Person;
import ru.ykhdr.securityproject.services.RegistrationService;
import ru.ykhdr.securityproject.util.PersonValidator;

@RequiredArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;

    private final PersonValidator personValidator;

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person){
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        personValidator.validate(person,bindingResult);

        if(bindingResult.hasErrors()){
            return "auth/registration";
        }

        registrationService.register(person);

        return "redirect:/auth/login";
    }


}

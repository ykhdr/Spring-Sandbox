package ru.ykhdr.library.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ykhdr.library.dao.PersonDao;
import ru.ykhdr.library.models.Person;

@AllArgsConstructor
@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDao personDao;

    @GetMapping()
    public String index(@NotNull Model model){
        model.addAttribute("people", personDao.index());

        return "people/index";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "people/new";
        }

        personDao.save(person);
        return "redirect:/people";
    }

}

package ru.ykhdr.crud.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ykhdr.crud.dao.PersonDAO;
import ru.ykhdr.crud.models.Person;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final PersonDAO personDAO;

    @GetMapping()
    public String adminPage(Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("people", personDAO.index());

        return "admin/adminPage";
    }

    @PatchMapping("/add")
    public String makeAdmin(@ModelAttribute("person") Person person){
        System.out.println(person.getId());

        return "redirect:/people";
    }
}

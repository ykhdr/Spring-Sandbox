package ru.ykhdr.library.controllers;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ykhdr.library.dao.PersonDao;

@AllArgsConstructor
@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDao personDao;

    @GetMapping()
    public String index(@NotNull Model model){
        model.addAttribute("people", personDao.index());

        return "index";
    }



}

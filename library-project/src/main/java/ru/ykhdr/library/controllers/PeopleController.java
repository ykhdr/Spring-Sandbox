package ru.ykhdr.library.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ykhdr.library.dao.BookDao;
import ru.ykhdr.library.dao.PersonDao;
import ru.ykhdr.library.models.Person;

@AllArgsConstructor
@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDao personDao;
    private final BookDao bookDao;

    @GetMapping()
    public String index(@NotNull Model model) {
        model.addAttribute("people", personDao.index());

        return "people/index";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/new";
        }

        personDao.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDao.show(id).orElse(null));
        model.addAttribute("books", bookDao.booksByHolder(id));
        return "people/show";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDao.delete(id);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDao.show(id).orElse(null));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, @PathVariable("id") int id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/edit";
        }

        personDao.update(id, person);
        return "redirect:/people";
    }

}

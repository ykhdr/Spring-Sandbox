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
import ru.ykhdr.library.models.Book;
import ru.ykhdr.library.models.Person;

@AllArgsConstructor
@Controller
@RequestMapping("/books")
public class BooksController {
    private final BookDao bookDao;
    private final PersonDao personDao;

    @GetMapping()
    public String index(@NotNull Model model) {
        model.addAttribute("books", bookDao.index());
        return "books/index";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/new";
        }

        bookDao.save(book);

        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Book book = bookDao.show(id).orElse(null);

        if(book == null){
            return "/books/show";
        }

        Person person = book.getHolderId() == 0 ? null : personDao.show(book.getHolderId()).orElse(null);

        model.addAttribute("book", book);
        model.addAttribute("person", person);

        return "/books/show";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookDao.delete(id);
        return "redirect:/books";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book, @PathVariable("id") int id, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "/books/edit";
        }

        bookDao.update(id,book);

        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookDao.show(id));
        return "/books/edit";
    }



}

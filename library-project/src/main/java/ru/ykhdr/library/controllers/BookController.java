package ru.ykhdr.library.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ykhdr.library.dao.BookDao;
import ru.ykhdr.library.models.Book;

@AllArgsConstructor
@Controller
@RequestMapping("/books")
public class BookController {
    private final BookDao bookDao;

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
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "books/new";
        }

        bookDao.save(book);

        return "redirect:/books";
    }
}

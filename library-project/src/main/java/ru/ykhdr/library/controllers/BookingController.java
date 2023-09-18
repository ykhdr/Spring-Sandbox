package ru.ykhdr.library.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ykhdr.library.dao.BookDao;

@AllArgsConstructor
@Controller
@RequestMapping("/booking")
public class BookingController {

    private final BookDao bookDao;

    @GetMapping()
    public String index(Model model){
        model.addAttribute("bookPersonInfo", bookDao.booksNamesWithHoldersNames());
        return "booking/index";
    }
}

package org.launchcode.controllers;

import org.launchcode.models.data.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("library")
public class LibraryController {

    @Autowired
    private BookDao bookDao;

    // Request path: /library
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("books", bookDao.findAll());
        model.addAttribute("title", "My Library");

        return "library/index";
    }

}

package org.launchcode.controllers;

import org.launchcode.models.Book;
import org.launchcode.models.data.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
        // model.addAttribute("genre", genreDao);

        return "library/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddBookForm(Model model) {
        model.addAttribute("title", "Add Book");
        model.addAttribute(new Book());
        return "library/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddBookForm(@ModelAttribute @Valid Book newBook,
                                       Errors errors,
                                       // @RequestParam int bookId,
                                       Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Book");
            return "library/add";
        }

        // Genre cat = genreDao.findOne(genreId);
        // newBook.setGenre(cat);

        bookDao.save(newBook);
        return "redirect:";

    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveBookForm(Model model) {
        model.addAttribute("books", bookDao.findAll());
        model.addAttribute("title", "Remove Book");
        return "library/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveBookForm(@RequestParam int[] bookIds) {

        for (int bookId : bookIds) {
            bookDao.delete(bookId);
        }

        return "redirect:";
    }

    @RequestMapping(value = "edit/{bookId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int bookId) {
        Book b = bookDao.findOne(bookId);
        model.addAttribute("book", b);
        return "library/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(int bookId, String title, String author, String description, String studentname) {
        Book b = bookDao.findOne(bookId); // grab object by the ID
        b.setTitle(title); // use the setters to change the value
        b.setAuthor(author);
        b.setDescription(description);
        b.setStudentname(studentname);
        bookDao.save(b);
        return "redirect:";
    }


}

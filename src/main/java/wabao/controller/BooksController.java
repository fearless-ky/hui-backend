package wabao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wabao.pojo.books;
import wabao.service.BookService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BooksController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "Books",method = RequestMethod.GET)
    public String books(Model model){

        List<books> list = new ArrayList<books>();
        list = bookService.searchBook();

        System.out.println("list = " + list.get(0).getBody());
        System.out.println("list = " + list.get(0).getAnnotate());
        System.out.println("list = " + list.get(0).getPoetphoto());
        model.addAttribute("code", 1);
        model.addAttribute("bookdatas", list);

        return "book-del";
    }
}

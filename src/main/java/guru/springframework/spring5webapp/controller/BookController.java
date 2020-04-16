package guru.springframework.spring5webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import guru.springframework.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	public String getAllBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());	
		return "books";
	}

}

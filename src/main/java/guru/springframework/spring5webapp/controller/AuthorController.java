package guru.springframework.spring5webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@RequestMapping(path = "/authors")
	public String getAllAuthors(Model model) {
		
		model.addAttribute("authors", authorRepository.findAll());
		return "authors/list";
	}

}

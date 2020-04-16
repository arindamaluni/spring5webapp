package guru.springframework.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements ApplicationRunner{
	
	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	PublisherRepository publisherRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		Author eric = new Author("Eric", "Evans");
		Book book = new Book("Domain Driven Design", "123123");
		Publisher publisher =new Publisher("Oriely", "Rue De La Cruz", "London", "Uxbridge", "HA5 7AZ");
		publisherRepository.save(publisher);
		
		eric.getBooks().add(book);
		book.getAuthors().add(eric);
		publisher.getBooks().add(book);
		book.setPublisher(publisher);
		
		authorRepository.save(eric);
		bookRepository.save(book);
		publisherRepository.save(publisher);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "2876278626");
		
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		publisher.getBooks().add(noEJB);
		noEJB.setPublisher(publisher);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(publisher);
		
		
		System.out.println("Publisher count:" + publisherRepository.count());
		System.out.println("Books count:" + publisher.getBooks().size());
		
		
	}
	

}

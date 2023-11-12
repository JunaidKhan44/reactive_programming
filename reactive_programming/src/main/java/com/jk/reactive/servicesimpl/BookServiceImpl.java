/**
 * 
 */
package com.jk.reactive.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.reactive.entities.Book;
import com.jk.reactive.repository.BookRepo;
import com.jk.reactive.services.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * junaid.khan
 *
 */

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo repo;
	
	@Override
	public Mono<Book> createBook(Book book) {
		// TODO Auto-generated method stub
		Mono<Book> obj = repo.save(book);
		return obj;
	}

	@Override
	public Flux<Book> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Mono<Book> get(int bookId) {
		// TODO Auto-generated method stub
		return repo.findById(bookId);
	}

	@Override
	public Mono<Book> update(Book book, int id) {
		// TODO Auto-generated method stub
		Mono<Book> obj = repo.findById(id);
		return obj.flatMap(s -> {

			s.setBookId(book.getBookId());
			s.setName(book.getName());
			s.setDescription(book.getDescription());
			s.setAuthor(book.getAuthor());
			s.setPublisher(book.getPublisher());
			return repo.save(s);

		});

	}

	@Override
	public Mono<Void> delete(int bookId) {
		// TODO Auto-generated method stub
		return repo.findById(bookId).flatMap(s -> repo.delete(s));
	}

	@Override
	public Flux<Book> search(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}

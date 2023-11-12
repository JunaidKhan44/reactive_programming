/**
 * 
 */
package com.jk.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jk.reactive.entities.Book;
import com.jk.reactive.services.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * junaid.khan
 *
 */

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	public BookService service;

	@PostMapping
	public Mono<Book> create(@RequestBody Book book){
		return service.createBook(book);
	}
	
	@GetMapping
	public Flux<Book>  getALlBook(){
		return service.getAll();
	}
	
	
	@GetMapping("/{bid}")
	public Mono<Book> get(@PathVariable("bid") int bookId){
		return service.get(bookId);
	}
	

	@PutMapping("/{bookId}")
	public Mono<Book> update(@RequestBody Book book,@PathVariable int id){
		return service.update(book, id);
	}

	
	@DeleteMapping("/{bookId}")
	public Mono<Void> delete(@PathVariable int bid){
		return service.delete(bid);
	}
}

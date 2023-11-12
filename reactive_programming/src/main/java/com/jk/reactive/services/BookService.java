/**
 * 
 */
package com.jk.reactive.services;

import com.jk.reactive.entities.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * junaid.khan
 *
 */
public interface BookService {
	
	public Mono<Book> createBook(Book book);
	public Flux<Book> getAll();
	public Mono<Book> get(int bookId);
	public Mono<Book> update(Book book,int id);
	public Mono<Void> delete(int bookId);
	public Flux<Book> search(String query);

}

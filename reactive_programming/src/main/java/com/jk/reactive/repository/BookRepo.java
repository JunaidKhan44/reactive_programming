/**
 * 
 */
package com.jk.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.jk.reactive.entities.Book;

/**
 * junaid.khan
 *
 */

@Repository
public interface BookRepo extends ReactiveCrudRepository<Book, Integer> {

}

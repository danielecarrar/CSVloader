package it.epicode.be;

import org.springframework.data.repository.CrudRepository;

import it.epicode.be.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}

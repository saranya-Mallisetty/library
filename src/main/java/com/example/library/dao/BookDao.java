package com.example.library.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.Book;

@Repository
public interface BookDao extends CrudRepository<Book, Integer> {

	@Query("SELECT e FROM Book e WHERE e.bookName LIKE %?1%")
    Optional<List<Book>> findAllByBookName(String bookName);
	
	@Query("SELECT e FROM Book e WHERE e.authorName LIKE %?1%")
    Optional<List<Book>> findAllByAuthorName(String authorName);

	Optional<List<Book>> findAllByCategory(String category);

	Book findAllByBookId(int bookId);

}

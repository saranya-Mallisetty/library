package com.example.library.service;

import java.util.List;

import com.example.library.dto.BookDetailsResponseDto;


public interface BookService {



	List<BookDetailsResponseDto> getBookDetailsByAuthorName(String authorName);

	List<BookDetailsResponseDto> getBookDetailsByCategory(String category);

	List<BookDetailsResponseDto> getBookDetailsByBookName(String bookName);

}

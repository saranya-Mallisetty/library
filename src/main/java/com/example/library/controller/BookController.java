package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.dto.BookDetailsResponseDto;
import com.example.library.service.BookService;
//BookController class displaying books

@RestController
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/book")
    public ResponseEntity<List<BookDetailsResponseDto>> searchBookDetails(@RequestParam(required=false) String bookName,@RequestParam(required=false) String authorName,@RequestParam(required=false) String category) {
		System.out.println(bookName);
		System.out.println(authorName);
		System.out.println(category);


	//	if((!"null".equals(bookName)) && (authorName.equals(null)) || (authorName.equals(null)) && (category.equals(null))) {
		if(bookName!=null) {	
			System.out.println("hello");

			
		    List<BookDetailsResponseDto> bookDetailsResponseDto=bookService.getBookDetailsByBookName(bookName);
		    System.out.println(bookDetailsResponseDto);
	        return new ResponseEntity<List<BookDetailsResponseDto>>(bookDetailsResponseDto,HttpStatus.OK);

		}
		else if(authorName!=null){
		    List<BookDetailsResponseDto> bookDetailsResponseDto=bookService.getBookDetailsByAuthorName(authorName);
	        return new ResponseEntity<List<BookDetailsResponseDto>>(bookDetailsResponseDto,HttpStatus.OK);

       }
		else {
			
		
			 List<BookDetailsResponseDto> bookDetailsResponseDto=bookService.getBookDetailsByCategory(category);
        return new ResponseEntity<List<BookDetailsResponseDto>>(bookDetailsResponseDto,HttpStatus.OK);
		}
			
    }
 
}

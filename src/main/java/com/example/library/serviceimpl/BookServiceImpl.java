package com.example.library.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.library.dao.BookDao;
import com.example.library.dto.BookDetailsResponseDto;
import com.example.library.model.Book;
import com.example.library.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookDao bookDao;

	@Override
	public List<BookDetailsResponseDto> getBookDetailsByBookName(String bookName) {
		Optional<List<Book>> bookDetails=bookDao.findAllByBookName(bookName);
		List<BookDetailsResponseDto> bookDetailsResponseDto=new ArrayList<>();
		if(bookDetails.isPresent()) {
			
			return bookDetails.get().stream().map(book -> getBookDetailsResponseDto(book)).collect(Collectors.toList());
			
		}
		else {
			return bookDetailsResponseDto;
		}
		 
	}
	private BookDetailsResponseDto getBookDetailsResponseDto(Book book) {
		
		BookDetailsResponseDto bookDetailsResponse=new BookDetailsResponseDto();
		BeanUtils.copyProperties(book, bookDetailsResponse);
		return bookDetailsResponse;
	}

	@Override
	public List<BookDetailsResponseDto> getBookDetailsByAuthorName(String authorName) {
		Optional<List<Book>>  bookDetails=bookDao.findAllByAuthorName(authorName);
		List<BookDetailsResponseDto> bookDetailsResponseDto=new ArrayList<>();
      if(bookDetails.isPresent()) {
			
			return bookDetails.get().stream().map(book -> getBookDetailsResponseDto1(book)).collect(Collectors.toList());
			
		}
		else {
			return bookDetailsResponseDto;
		}
		 
	}
	private BookDetailsResponseDto getBookDetailsResponseDto1(Book book) {
		
		BookDetailsResponseDto bookDetailsResponse=new BookDetailsResponseDto();
		BeanUtils.copyProperties(book, bookDetailsResponse);
		return bookDetailsResponse;
	}

		
		
	

	@Override
	public List<BookDetailsResponseDto> getBookDetailsByCategory(String category) {
		/*List<Book>  bookDetails=bookDao.findAllByCategory(category);
		List<BookDetailsResponseDto> bookDetailsResponseDto=new ArrayList<>();
		//BeanUtils.copyProperties(bookDetails, bookDetailsResponseDto);
		
		
		return bookDetailsResponseDto;*/
		List<BookDetailsResponseDto> bookDetailsResponseDto = new ArrayList<>();
		Optional<List<Book>> bookDetailsList = bookDao.findAllByCategory(category);

		System.out.println(bookDetailsList);

		if (bookDetailsList.isPresent()) {
			return bookDetailsList.get().stream().map(bookDetails -> getBookResponseDto(bookDetails))
					.collect(Collectors.toList());
		} else {
			return bookDetailsResponseDto;
		}

	}

	private BookDetailsResponseDto getBookResponseDto(Book bookDetails) {
		BookDetailsResponseDto bookResponseDtoList = new BookDetailsResponseDto();
	System.out.println(bookDetails);
		BeanUtils.copyProperties(bookDetails, bookResponseDtoList);
		System.out.println(bookResponseDtoList);

		return bookResponseDtoList;
	}

	}




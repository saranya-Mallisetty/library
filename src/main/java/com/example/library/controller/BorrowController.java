package com.example.library.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.dto.BorrowRequestDto;
import com.example.library.dto.BorrowResponseDto;
import com.example.library.service.BorrowService;



@RestController
public class BorrowController {
	@Autowired
	BorrowService borrowService;
	private static Log logger = LogFactory.getLog(BorrowController.class);

	@PostMapping("/books/{bookId}")
	public ResponseEntity<BorrowResponseDto> findBookDetails(@RequestBody BorrowRequestDto borrowRequestDto,@PathVariable("bookId") int bookId) {
		logger.info("Inside Searching based on userId&borrowdate getting book details");

		BorrowResponseDto borrowResponsedto = borrowService.borrowBookDetails(borrowRequestDto,bookId);

		return new ResponseEntity<BorrowResponseDto>(borrowResponsedto, HttpStatus.OK);

	}


}

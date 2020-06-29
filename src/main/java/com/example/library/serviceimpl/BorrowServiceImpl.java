package com.example.library.serviceimpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.dao.BookDao;
import com.example.library.dao.BorrowDao;
import com.example.library.dto.BorrowRequestDto;
import com.example.library.dto.BorrowResponseDto;
import com.example.library.model.Book;
import com.example.library.model.Borrow;
import com.example.library.service.BorrowService;



@Service
public class BorrowServiceImpl implements BorrowService {
	private static Log logger = LogFactory.getLog(BorrowServiceImpl.class);
	@Autowired
	BorrowDao borrowDao;
	@Autowired
	BookDao bookDao;

	@Override
	public BorrowResponseDto borrowBookDetails(BorrowRequestDto borrowRequestDto, int bookId) {
		Borrow borrow=new Borrow();
		borrow.setUserId(borrowRequestDto.getUserId());
		borrow.setBookId(bookId);
		LocalDate date = LocalDate.parse(borrowRequestDto.getBorrowDate());
		borrow.setBorrowDate(date);
		borrow.setDueDate(date.plusDays(2));
		
		borrowDao.save(borrow);
		Book book=bookDao.findAllByBookId(bookId);
		book.setNoOfCopies(book.getNoOfCopies()-1);
		
		bookDao.save(book);
		
		BorrowResponseDto borrowResponseDto=new BorrowResponseDto();
		BeanUtils.copyProperties(book, borrowResponseDto);
		return borrowResponseDto;
		
		
		
		
		
		

		
	}

	
}
	
		
	

	



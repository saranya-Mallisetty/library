package com.example.library.service;


import com.example.library.dto.BorrowRequestDto;
import com.example.library.dto.BorrowResponseDto;

public interface BorrowService {


	BorrowResponseDto borrowBookDetails(BorrowRequestDto borrowRequestDto, int bookId);

}

package com.example.library.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.Borrow;


@Repository
public interface BorrowDao extends CrudRepository<Borrow, Integer> {



}

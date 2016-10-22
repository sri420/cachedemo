package com.demo.main.repository;

import com.demo.main.model.Book;

public interface BookRepository {

    Book getByIsbn(String isbn);

	String getByQuoteRefNo(String isbn);

}
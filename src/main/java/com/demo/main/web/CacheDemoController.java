package com.demo.main.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.main.repository.BookRepository;

@RestController
public class CacheDemoController {
	private static final Logger logger = LoggerFactory.getLogger(CacheDemoController.class);

	private final BookRepository bookRepository;

	public CacheDemoController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;

	}

	
	@GetMapping("/getValues")
	public void getValues(){
		logger.info("isbn-1234 -->" + bookRepository.getByQuoteRefNo("12"));
		logger.info("isbn-1234 -->" + bookRepository.getByQuoteRefNo("12"));
		logger.info("isbn-1234 -->" + bookRepository.getByQuoteRefNo("12"));
	}
}

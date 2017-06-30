package com.demo.main.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {

	private static final Logger logger = LoggerFactory.getLogger(SimpleBookRepository.class);
	
	/*
	@Override
    @Cacheable(value="books")
    public Book getByIsbn(String isbn) {
		logger.info("Inside getByIsbn in SimpleBookRepository");
        simulateSlowService();
        return new Book(isbn, "Some book");
    }*/
	
    @Override
    @Cacheable(value="quotes")
    public String getByQuoteRefNo(String isbn) {
    	logger.info("Inside getByQuoteRefNo in SimpleBookRepository");
    	simulateSlowService();
        return "Quote:"+isbn;
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

	
}

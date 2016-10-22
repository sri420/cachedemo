package com.demo.main.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.demo.main.model.Book;

@Component
public class SimpleBookRepository implements BookRepository {

	@Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }
	
    @Override
    @Cacheable("quotes")
    public String getByQuoteRefNo(String isbn) {
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

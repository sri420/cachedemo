package com.demo.main.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class SimpleService  {

	private static final Logger logger = LoggerFactory.getLogger(SimpleService.class);
	
	
	@Value("${quotesCacheEnabled}")
	private boolean quotesCacheEnabled;
	
	@Value("${booksCacheEnabled}")
	private boolean booksCacheEnabled;
	
	
	
	public boolean getQuotesCacheEnabled(){
		logger.info("quotesCacheEnabled:" + quotesCacheEnabled);
		return quotesCacheEnabled;
	}

	public boolean getBooksCacheEnabled(){
		logger.info("booksCacheEnabled" + booksCacheEnabled);
		return booksCacheEnabled;
	}
    
	@Cacheable(value="quotes",condition="#root.target.quotesCacheEnabled==true")
    public String getByQuoteRefNo(String isbn) {
    	logger.info("Inside getByQuoteRefNo in SimpleBookRepository");
    	simulateSlowService();
        return "Quote:"+isbn;
    }
    
    @Cacheable(value="books",condition="#root.target.booksCacheEnabled==true")
    public String getBookByNo(String bookno) {
    	logger.info("Inside getBookByNo in SimpleBookRepository");
    	simulateSlowService();
        return "Book:"+bookno;
    }

  
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

	
}

package com.demo.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.main.repository.BookRepository;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final BookRepository bookRepository;
    
   /* @Autowired
    CacheConfig cacheConfiguration;*/

    public AppRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        
    }

    @Override
    public void run(String... args) throws Exception {
    	
    	/*logger.info("***ClientMode:" + cacheConfiguration.getClientMode());
    	
    	logger.info("***caches:" +cacheConfiguration.getCaches());*/
    	
        logger.info(".... Fetching books");
        
        
       logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        
        
        logger.info("isbn-1234 -->" + bookRepository.getByQuoteRefNo("12"));
        logger.info("isbn-1234 -->" + bookRepository.getByQuoteRefNo("12"));
        logger.info("isbn-1234 -->" + bookRepository.getByQuoteRefNo("123"));
        logger.info("isbn-1234 -->" + bookRepository.getByQuoteRefNo("12"));
        logger.info("isbn-1234 -->" + bookRepository.getByQuoteRefNo("123"));
    }

}
package booksearch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookSearch {

//    @Bean
//    public BookRepository getRepo() {
//        return new BookRepository();
//    }
//
//    @Bean
//    public BookSearchService getService() {
//        return new BookSearchService();
//    }

    @Bean
    public RecommendationService getReco() {
        return new RecommendationService();
    }

}

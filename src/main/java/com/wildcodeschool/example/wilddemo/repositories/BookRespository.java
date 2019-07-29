package com.wildcodeschool.example.wilddemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.wildcodeschool.example.wilddemo.entities.Book;

@Repository
public interface BookRespository extends JpaRepository<Book, Integer> {

    // custom query to search to blog post by title or content
    List<Book> findByTitleContainingOrDescriptionContaining(String text, String textAgain);
    
}


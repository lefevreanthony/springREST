package com.wildcodeschool.example.wilddemo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import com.wildcodeschool.example.wilddemo.entities.Book;
import com.wildcodeschool.example.wilddemo.repositories.BookRespository;

@RestController
public class BookController {

    @Autowired
    BookRespository bookrepository;

    @GetMapping("/books")
    public List<Book> index(){
        return bookrepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book show(@PathVariable int id){
        return bookrepository.findById(id).get();
    }

    @PostMapping("/books/search")
    public List<Book> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return bookrepository.findByTitleContainingOrDescriptionContaining(searchTerm, searchTerm);
    }

    @PostMapping("/books")
    public Book create(@RequestBody Book book){
        return bookrepository.save(book);
    }

    @PutMapping("/books/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book){
       
        Book bookToUpdate = bookrepository.findById(id).get();
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setDescription(book.getDescription());
        return bookrepository.save(bookToUpdate);
    }

    @DeleteMapping("books/{id}")
    public boolean delete(@PathVariable int id){
        bookrepository.deleteById(id);
        return true;
    }
}
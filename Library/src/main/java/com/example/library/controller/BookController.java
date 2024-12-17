package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.entity.Book;
import com.example.library.service.BookService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	//to add book name
	@PostMapping("/addBookName")
	@ResponseStatus(HttpStatus.CREATED)
	public String setBookName(@RequestBody BookDetails bookDetails ) {
        bookService.setBookName(bookDetails.getBookName());
        return "Book name set successfully!";
    }
	
	//to add author name
	@PostMapping("/addAuthorName")
	@ResponseStatus(HttpStatus.CREATED)
    public String setAuthorName(@RequestBody BookDetails bookDetails) {
        bookService.setAuthorName(bookDetails.getAuthorName());
        return "Author name set successfully!";
    }
	
	//to add available books
	@PostMapping("/addAvailableBooks")
	@ResponseStatus(HttpStatus.CREATED)
    public String setAvailableBooks(@RequestBody BookDetails bookDetails ) {
        bookService.setAvailableBooks(bookDetails.getAvailableBooks());
        return "Available books count set successfully!";
    }
	
	//to add all the book details at one go
	@PostMapping("/addBookDetails")
	@ResponseStatus(HttpStatus.CREATED)
	public String addBookDetails(@RequestBody BookDetails bookDetails) {
	    bookService.addBookDetails(bookDetails);
	    return "Your library database is added successfully!";
	}

	//to get the specific(one) book details
	@GetMapping("/getBookDetails/{id}")
	public Book getBookDetails(@PathVariable Long id) {
	    return bookService.getBookDetailsById(id);
	}

	//to update the specific(one) book details
	@PutMapping("/updateBookDetails/{id}")
	public Book updateBookDetails(@PathVariable Long id,@RequestBody Book existingBook) {
		existingBook.setBookId(id);
			return bookService.updateBookDetails(existingBook);	
	}
	
	//to delete the specific(one) book details
	@DeleteMapping("/deleteBookDetails/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String deleteBookDetails(@PathVariable Long id) {
		bookService.deleteBookDetails(id);
		return "Your book is deleted successfully!";
	}	
}

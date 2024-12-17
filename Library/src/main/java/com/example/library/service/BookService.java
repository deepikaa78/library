package com.example.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.controller.BookDetails;
import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class BookService {
	
	@Autowired
    private BookRepository bookRepository;

	public void setBookName(String bookName) {
	    bookDetails.setBookName(bookName);
	}

	public void setAuthorName(String authorName) {
	    bookDetails.setAuthorName(authorName);
	}

	public void setAvailableBooks(int availableBooks) {
	    bookDetails.setAvailableBooks(availableBooks);
	}

    public void addBookDetails(BookDetails bookDetails) {
        Book book = new Book();
       // book.setBookId(bookDetails.getBookId());
        book.setBookName(bookDetails.getBookName());
        book.setAuthorName(bookDetails.getAuthorName());
        book.setAvailableBooks(bookDetails.getAvailableBooks());
        bookRepository.save(book); // Save the Book entity to the database
    }
	
private BookDetails bookDetails = new BookDetails();


public Book getBookDetailsById(Long id) {	
	return bookRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Book not found with ID: " + id));
}

public Book updateBookDetails(Book existingBook) {
    Book bookupdate = bookRepository.findById(existingBook.getBookId())
        .orElseThrow(() -> new EntityNotFoundException("Book not found with ID: " + existingBook.getBookId()));
    bookupdate.setBookName(existingBook.getBookName());
    bookupdate.setAuthorName(existingBook.getAuthorName());
    bookupdate.setAvailableBooks(existingBook.getAvailableBooks());
    return bookRepository.save(bookupdate);
}

public void deleteBookDetails(Long id) {
    bookRepository.deleteById(id);
}

}


package com.example.library.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	@Column(name = "book_id")
	private Long bookId;
	
	@Column(name = "book_name")
    private String bookName;
 
	@Column(name = "author_name")
    private String authorName;
    
	@Column(name = "available_books")
    private int availableBooks;
    
	public Book() {
		{}
	}
	public Book(Long bookId, String bookName, String authorName, int availableBooks) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.availableBooks = availableBooks;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getAvailableBooks() {
		return availableBooks;
	}
	public void setAvailableBooks(int availableBooks) {
		this.availableBooks = availableBooks;
	}
	
	
}

package com.example.library.controller;

public class BookDetails {

	
	private String bookName;
    private String authorName;
    private int availableBooks;
    
   
	public void setBookName(String bookName) {
		// TODO Auto-generated method stub
		this.bookName = bookName;
	}
	
	public void setAuthorName(String authorName) {
		// TODO Auto-generated method stub
		this.authorName = authorName;
	}

	public void setAvailableBooks(int availableBooks) {
		// TODO Auto-generated method stub
		 this.availableBooks = availableBooks;
	}

	public String getBookName() {
        return bookName;
    }
	public String getAuthorName() {
        return authorName;
    }
	
	public int getAvailableBooks() {
        return availableBooks;
    }
}

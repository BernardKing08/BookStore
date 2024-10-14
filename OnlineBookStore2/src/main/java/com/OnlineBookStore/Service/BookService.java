package com.OnlineBookStore.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OnlineBookStore.Model.Book;
import com.OnlineBookStore.Repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		 return (List<Book>) bookRepository.findAll();
	}

	// Method to get a single book by ID
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}

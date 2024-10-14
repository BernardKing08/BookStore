package com.OnlineBookStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineBookStore.Model.Book;
import com.OnlineBookStore.Model.Cart;

@Service
public class CartService {

	//getting an instance of cart pojo
	@Autowired
	private Cart cart; 

    // Method to add a book to the cart
	public void addBook(Book newBook) {
	    // Flag to check if the book already exists in the cart
	    boolean bookExists = false;

	    // Loop through the books in the cart
	    for (Book bookInCart : cart.getBooksInCart()) {
	        // Compare books by their ID (or UUID)
	        if (bookInCart.getUuid().equals(newBook.getUuid())) {
	            // If the book exists, increment the quantity
	            bookInCart.setQty(bookInCart.getQty() + 1);
	            bookExists = true;
	            break;
	        }
	    }

	    // If the book does not exist, add it to the cart
	    if (!bookExists) {
	        newBook.setQty(1);  // Ensure quantity is set to 1 when first added
	        cart.getBooksInCart().add(newBook);
	    }
	}


    public void removeBook(String uuid) {
        //Find the book in the cart by UUID using streams
        cart.getBooksInCart().stream()
            .filter(book -> book.getUuid().equals(uuid))
            .findFirst()
            .ifPresent(book -> {
                if (book.getQty() > 1) {
                    // Decrease the quantity if more than 1
                    book.setQty(book.getQty() - 1);
                } else {
                    // Remove the book if quantity is 1 or less
                    cart.getBooksInCart().remove(book);
                }
            });
    }


    // Method to get all books in the cart
    public List<Book> getCart() {
        return cart.getBooksInCart();
    }

	public double getTotalPrice() {
		// TODO Auto-generated method stub
		return cart.getTotalPrice();
	}
}

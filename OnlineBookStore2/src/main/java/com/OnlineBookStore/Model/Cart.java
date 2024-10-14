package com.OnlineBookStore.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Component

public class Cart {
    private List<Book> booksInCart = new ArrayList<>();

    // Calculate the total price dynamically
    public double getTotalPrice() {
        return booksInCart.stream()
            .mapToDouble(book -> book.getPrice() * book.getQty())
            .sum();
    }
}
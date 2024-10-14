package com.OnlineBookStore.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "books")
@NoArgsConstructor
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "name must not be blank")
	@Size(min = 3)
	private String name; 
	
	//uuid for keeping track of books in cart
	private String uuid;

	private String image_url;
	
	@NotBlank(message = "author must not be blank")
	@Size(min = 5)
	private String author; 
	
	@NotBlank(message = "description must not be blank")
	@Size(min = 10)
	private String description;
	
	//keeps track of the nummber of book-items in the cart
	private int qty;
	
	//price of the item
	private double price;
	
	
}

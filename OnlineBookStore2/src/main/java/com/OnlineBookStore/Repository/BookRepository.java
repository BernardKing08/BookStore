package com.OnlineBookStore.Repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.OnlineBookStore.Model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	Optional<Book> findByUuid(String uuid);
}

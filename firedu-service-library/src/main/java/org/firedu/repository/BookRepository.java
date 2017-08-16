package org.firedu.repository;

import org.firedu.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);

    @Query(value = "select new Book(id, title, author, translator, description, language, " +
            "subject1, subject2, datetime, publisher, asin, uuid, cover) " +
            "from Book where id = ?1")
    Book findById(Long id);
}

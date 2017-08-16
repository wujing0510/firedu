package org.firedu.repository;

import org.firedu.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select b from Book b where b.title like %?1% ")
    List<Book> findByTitle(@Param("title") String title);

}

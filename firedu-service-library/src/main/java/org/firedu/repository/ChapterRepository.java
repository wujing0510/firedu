package org.firedu.repository;

import org.firedu.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    @Query(value = "select new Chapter(id, title, description, order_num) " +
            "from Chapter where book_id = ?1")
    List<Chapter> findByBookId(Long bookId);
}

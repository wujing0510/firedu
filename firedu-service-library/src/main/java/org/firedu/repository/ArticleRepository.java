package org.firedu.repository;

import org.firedu.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "select new Article(id, title, description, order_num) " +
            "from Article where chapter_id = ?1")
    List<Article> findByChapterId(Long chapterId);

    @Query(value = "select new Article(id, title, description, order_num) " +
            "from Article where book_id = ?1")
    List<Article> findByBookId(Long bookId);

    @Query(value = "select new Article(id, title, description, order_num) " +
            "from Article where volume_id = ?1")
    List<Article> findByVolumeId(Long volumeId);
}

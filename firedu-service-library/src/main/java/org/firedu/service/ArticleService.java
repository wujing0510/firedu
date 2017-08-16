package org.firedu.service;

import org.firedu.entity.Article;
import org.firedu.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO
 *
 * @author Wu Jing
 * @date 2017-08-10 22:37:31
 */

@Service
@Transactional
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findByBookId(Long bookId) {
        return articleRepository.findByBookId(bookId);
    }

    public List<Article> findByVolumeId(Long volumeId) {
        return articleRepository.findByVolumeId(volumeId);
    }

    public List<Article> findByChapterId(Long chapterId) {
        return articleRepository.findByChapterId(chapterId);
    }

}

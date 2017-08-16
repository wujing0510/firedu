package org.firedu.web;

import org.firedu.entity.Article;
import org.firedu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @author Wu Jing
 * @date 2017-08-11 23:04:10
 */

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/findByBookId")
    public List<Article> findByBookId(@RequestParam("bookId") Long bookId) {
        List<Article> articles = articleService.findByBookId(bookId);
        return articles;
    }
    @RequestMapping("/findByVolumeId")
    public List<Article> findByVolumeId(@RequestParam("volumeId") Long volumeId) {
        List<Article> articles = articleService.findByVolumeId(volumeId);
        return articles;
    }
    @RequestMapping("/findByChapterId")
    public List<Article> findByChapterId(@RequestParam("chapterId") Long chapterId) {
        List<Article> articles = articleService.findByChapterId(chapterId);
        return articles;
    }
}

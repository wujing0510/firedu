package org.firedu.web;

import org.firedu.entity.Chapter;
import org.firedu.service.ChapterService;
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
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/findById")
    public Chapter findById(@RequestParam("id") Long id) {
        Chapter chapter = chapterService.findOne(id);
        return chapter;
    }
    @RequestMapping("/findByBookId")
    public List<Chapter> findByBookId(@RequestParam("bookId") Long bookId) {
        List<Chapter> chapters = chapterService.findByBookId(bookId);
        return chapters;
    }
}

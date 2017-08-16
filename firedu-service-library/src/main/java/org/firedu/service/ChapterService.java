package org.firedu.service;

import org.firedu.entity.Chapter;
import org.firedu.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author Wu Jing
 * @date 2017-08-11 23:04:55
 */

@Service
public class ChapterService {
    @Autowired
    private ChapterRepository chapterRepository;

    public Chapter findOne(Long id) {
        return chapterRepository.findOne(id);
    }
}

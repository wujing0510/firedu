package org.firedu.service;

import org.firedu.entity.BookVo;
import org.firedu.service.fallback.BookServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "firedu-service-library", fallback = BookServiceFallback.class)
public interface BookService {

    @RequestMapping("/book/findById")
    BookVo findById(@RequestParam("id") String id);

    @RequestMapping("/book/findByIds")
    List<BookVo> findByIds(@RequestParam("ids") String ids);
}

package com.example.jpa;

import com.example.jpa.article.Article;
import com.example.jpa.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/create")
    public Long create() {
        return articleService.create("hello");
    }

    @GetMapping("/expire")
    public void expire(Long id) {
        articleService.expire(id);
    }

    @GetMapping("/get")
    public ArticleResponse get(Long id) {
        return ArticleResponse.of(articleService.get(id));
    }
}

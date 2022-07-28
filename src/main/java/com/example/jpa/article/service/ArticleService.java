package com.example.jpa.article.service;

import com.example.jpa.article.Article;
import com.example.jpa.article.event.ArticleExpiredEvent;
import com.example.jpa.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository repository;
    private final ApplicationEventPublisher publisher;

    public Long create(String content) {
        Article article = Article.builder()
                .content(content)
                .build();

        return repository.save(article).getId();
    }

    @Transactional
    public void expire(Long id) {
        Article article = repository.getById(id);
        article.expire();
        publisher.publishEvent(new ArticleExpiredEvent(id));
    }

    @Transactional
    public Article get(Long id) {
        Article article = repository.getById(id);
        log.info("----> id={} 조회 - {}", id, article);
        return article;
    }
}

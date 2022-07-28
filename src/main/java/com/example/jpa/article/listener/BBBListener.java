package com.example.jpa.article.listener;

import com.example.jpa.article.event.ArticleExpiredEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j

public class BBBListener {
    @Order(0)
    @TransactionalEventListener
    public void process(ArticleExpiredEvent event) {
        log.info("BBBListener {}", event.getId());
    }
}

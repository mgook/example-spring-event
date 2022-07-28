package com.example.jpa.article.listener;

import com.example.jpa.article.event.ArticleExpiredEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j

public class CListener {
    @Order(Ordered.LOWEST_PRECEDENCE)
    @TransactionalEventListener
    public void process(ArticleExpiredEvent event) {
        log.info("CListener {}", event.getId());
    }
}

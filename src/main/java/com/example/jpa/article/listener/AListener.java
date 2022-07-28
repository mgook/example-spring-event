package com.example.jpa.article.listener;

import com.example.jpa.article.event.ArticleExpiredEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j

public class AListener {

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @TransactionalEventListener
    public void process(ArticleExpiredEvent event) {
//        if (event.getId() > 0) {
//            log.error("ERROR");
//            throw new NullPointerException();
//        }

        log.info("AListener {}", event.getId());
    }
}

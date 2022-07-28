package com.example.jpa.article.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleExpiredEvent {
    private Long id;
}

package com.example.jpa;

import com.example.jpa.article.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleResponse {
    private Long id;
    private Article.Status status;

    public static ArticleResponse of(Article domain) {
        return new ArticleResponse(domain.getId(), domain.getStatus());
    }
}

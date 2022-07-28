package com.example.jpa.article;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@Slf4j
public class Article {

    public void expire() {
        log.info("----> change status to Expire");
        this.status = Status.EXPIRED;
    }

    public enum Status {
        LIVE, EXPIRED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String memberNo;

    private Status status = Status.LIVE;
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "article_id")
//    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Article(String content, String memberNo) {
        this.content = content;
        this.memberNo = memberNo;
    }

//    public void addComment(Comment comment) {
//        this.comments.add(comment);
//    }
}

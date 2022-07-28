//package com.example.jpa.article.repository;
//
//import com.example.jpa.article.Article;
//import com.example.jpa.article.Comment;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@SpringBootTest
//class ArticleRepositoryTest {
//
//    @Autowired
//    private ArticleRepository articleRepository;
//
//    @Autowired
//    private EntityManager em;
//
//    @BeforeEach
//    void setup() {
//        for (int i = 0; i < 1; i++) {
//            Article article = Article.builder()
//                    .content("게시글-" + i)
//                    .memberNo("MEMBER1")
//                    .build();
//
//            article.addComment(Comment.builder().content("comment 1").build());
//            article.addComment(Comment.builder().content("comment 2").build());
//            article.addComment(Comment.builder().content("comment 3").build());
//
//            articleRepository.save(article);
//        }
//
//        em.clear();
//
//        System.out.println("----> 업데이트완료");
//    }
//
//    @Transactional
//    @Test
//    @DisplayName("N+1")
//    void nplusone() {
//        List<String> comments = articleRepository.findAll()
//                .stream()
//                .flatMap(it -> it.getComments().stream())
//                .map(Comment::getContent)
//                .collect(Collectors.toList());
////        Article article1 = articleRepository.findById(article.getId()).get();
////        article1.getComments().forEach(it -> System.out.println(it.getContent()));
//    }
//
//    @Test
//    @DisplayName("fetch join")
//    void fetchJoin() {
//        /*
//        fetch join 으로 offset limit을 하면 발생하는 문제가 궁금해서.
//        limit이 쿼리에 날아가지 않고, 메모리에서 리밋을 처리한다.
//         */
//        List<Article> articles = articleRepository.findAllFetch(PageRequest.of(0, 2));
//
//        System.out.println(">>>> fetch join 결과");
//        articles.forEach(it -> {
//            System.out.println("게시글 : " + it.getId());
//            it.getComments().forEach(comment -> System.out.println("---> 코멘트 : " + comment.getContent()));
//        });
//    }
//
//    @Test
//    @DisplayName("fetch join by memberNo")
//    void fetchJoinByMemberNo() {
//        /*
//        fetch join 으로 offset limit을 하면 발생하는 문제가 궁금해서.
//        데이터 뻥튀기 이슈.
//        join 하는 테이블의 데이터가 곱하기 되어 나오고, 이때 n쪽 엔티티를 List 컬렉션에 넣어줄수가 없어서 (주인을 모름) 중복 발생
//
//         */
//        List<Article> articles = articleRepository.findAllFetchByMemberNo("MEMBER1", null);
//
//        System.out.println(">>>> fetch join 결과");
//        articles.forEach(it -> {
//            System.out.println("게시글 : " + it.getId());
//            it.getComments().forEach(comment -> System.out.println("---> 코멘트 : " + comment.getContent()));
//        });
//    }
//}
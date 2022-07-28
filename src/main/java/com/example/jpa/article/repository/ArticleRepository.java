package com.example.jpa.article.repository;

import com.example.jpa.article.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

//    @Query("select a from Article a join fetch a.comments")
//    List<Article> findAllFetch(Pageable pageable);
//
//    @Query("select a from Article a join fetch a.comments where a.memberNo=:memberNo")
//    List<Article> findAllFetchByMemberNo(String memberNo, @Nullable Pageable pageable);
}

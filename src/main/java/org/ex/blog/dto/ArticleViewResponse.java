package org.ex.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ex.blog.domain.Article;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ArticleViewResponse {
    private Long id;
    private String title;
    private String content;
    private String category1;
    private String category2;
    private LocalDateTime createdAt;

    public ArticleViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.category1 = article.getCategory1();
        this.category2 = article.getCategory2();
        this.createdAt = article.getCreateAt();
    }
}

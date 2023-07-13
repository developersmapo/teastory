package org.ex.blog.dto;

import lombok.Getter;
import org.ex.blog.domain.Article;

@Getter
public class ArticleListViewResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String category1;
    private final String category2;

    public ArticleListViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.category1 = article.getCategory1();
        this.category2 = article.getCategory2();
    }
}

package org.ex.blog.dto;

import lombok.Getter;
import org.ex.blog.domain.Article;

@Getter
public class ArticleResponse {
    private final String title;
    private final String content;
    private final String photo;
    private final Long user_id;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
        this.photo = article.getPhoto();
        this.user_id = article.getUser_id();
    }
}

package org.ex.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ex.blog.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {

    private String title;
    private String content;
    private String category1;
    private String category2;
    private String photo;

    public Article toEntity(Long id) {
        return Article.builder().title(title)
                .content(content)
                .category1(category1)
                .category2(category2)
                .user_id(id)
                .photo(photo)
                .build();
    }

    // 서비스
}

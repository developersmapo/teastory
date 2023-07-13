package org.ex.blog.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "category1", nullable = false)
    private String category1;

    @Column(name = "category2")
    private String category2;

    @Column(name = "user_id")
    private Long user_id;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Article(String title, String content, String category1, String category2) {
        this.title = title;
        this.content = content;
        this.category1 = category1;
        this.category2 = category2;
    }

    public void update(String title, String content, String category1, String category2) {
        this.title = title;
        this.content = content;
        this.category1 = category1;
        this.category2 = category2;
    }
}

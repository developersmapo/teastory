package org.ex.blog.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "userconfig")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class UserConfig {
    @Id
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "arrangement")
    private String arrangement;

    @Builder
    public UserConfig(String arrangement) {
        this.arrangement = arrangement;
    }
}

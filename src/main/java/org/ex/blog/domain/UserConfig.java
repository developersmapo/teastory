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

    @Column(name = "name")
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "val")
    private String val;

    @Builder
    public UserConfig(Long id, String name, String code, String val) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.val = val;
    }
}

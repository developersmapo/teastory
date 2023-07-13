package org.ex.blog.repository;

import org.ex.blog.domain.UserConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserConfigRepository extends JpaRepository<UserConfig, Long> {
    List<UserConfig> findByIdAndName(Long id, String name);
}

package org.ex.blog.service;

import lombok.RequiredArgsConstructor;
import org.ex.blog.domain.UserConfig;
import org.ex.blog.repository.UserConfigRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserConfigService {
    private final UserConfigRepository userConfigRepository;

    public List<UserConfig> getConfigList(Long id, String name) {
        return userConfigRepository.findByIdAndName(id, name);
    }
}

package org.ex.blog.controller;

import org.ex.blog.domain.UserConfig;
import org.ex.blog.service.UserConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {

    private final UserConfigService userConfigService;

    // 생성자 주입을 사용해서 UserConfigService를 주입받음
    public CategoryController(UserConfigService userConfigService) {
        this.userConfigService = userConfigService;
    }

    @GetMapping("/new-category")
    public String newCategory(Model model) {
        // 카테고리 목록을 가져오는 메서드를 호출하여 카테고리 목록을 얻음
        List<String> categories = getCategories(); // 예시로 간단히 리스트를 반환하는 메서드를 호출 (실제로는 DB 등에서 데이터를 가져와야 함)

        // 모델에 "categoryList" 이름으로 카테고리 목록을 추가
        model.addAttribute("categoryList", categories);

        // 뷰의 이름을 반환
        return "newCategory";
    }

    @PostMapping("/new-category")
    public String createCategory(@RequestParam String categoryName) {
        // 새로운 카테고리를 저장하거나 처리하는 로직을 구현
        // userConfigService를 이용하여 새로운 카테고리를 저장하는 예시

        UserConfig newCategory = new UserConfig();
        newCategory.setType("category");
        newCategory.setValue(categoryName);
        // 여기서 새로운 카테고리를 DB 등에 저장하는 로직을 추가해야 함

        return "redirect:/new-article";
    }

    // 카테고리 목록을 가져오는 메서드 (예시)
    private List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        categories.add("카테고리 1");
        categories.add("카테고리 2");
        categories.add("카테고리 3");
        // ... 실제로는 DB 등에서 데이터를 가져와서 이곳에 추가해야 함
        return categories;
    }
}
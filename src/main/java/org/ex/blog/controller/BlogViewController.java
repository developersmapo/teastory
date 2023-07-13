package org.ex.blog.controller;

import org.ex.blog.domain.Article;
import org.ex.blog.domain.User;
import org.ex.blog.domain.UserConfig;
import org.ex.blog.dto.ArticleViewResponse;
import org.ex.blog.dto.ArticleListViewResponse;
import org.ex.blog.service.BlogService;

import org.ex.blog.service.UserConfigService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;
    private final UserConfigService userConfigService;

    @GetMapping("/myblog")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleListViewResponse::new)
                .collect(Collectors.toList());
        model.addAttribute("articles", articles);
        return "myblog";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));
        return "article";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model, @AuthenticationPrincipal User user) {

        if (id == null) {
            // 로그인한 사용자의 카테고리 목록 불러오기
            List<UserConfig> categories = userConfigService.getConfigList(user.getId(), "category");

            model.addAttribute("categoryList", categories);
            model.addAttribute("article", new ArticleViewResponse());
        } else {
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }
        return "newArticle"; // 수정된 부분: "new-article"로 변경
    }

    @PostMapping("/new-article")
    public String createArticle(@ModelAttribute ArticleViewResponse articleViewResponse, Model model) {
        // 새로운 글 등록 로직 구현 (blogService를 사용하여 등록)

        // 등록 후 myblog에서 새로운 글 목록을 가져와서 모델에 추가
        List<ArticleListViewResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleListViewResponse::new)
                .collect(Collectors.toList());
        model.addAttribute("articles", articles);

        return "redirect:/myblog";
    }

    @GetMapping("/error")
    public String handleError() {
        // 에러 페이지로 이동할 코드 또는 뷰 이름을 반환하세요.
        return "error";
    }
}
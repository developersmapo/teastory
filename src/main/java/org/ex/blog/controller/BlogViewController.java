package org.ex.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    public class BlogViewController {

        @GetMapping("/myblog")
        public String myblog() {
            return "myblog";
        }

        @GetMapping("/article")
        public String article() {
            return "article";
        }
    }

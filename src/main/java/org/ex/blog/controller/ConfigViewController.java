package org.ex.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfigViewController {

    @GetMapping("/config")
    public String config() {
        return "config";
    }
}

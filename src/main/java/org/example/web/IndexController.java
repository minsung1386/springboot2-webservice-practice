package org.example.web;

import lombok.RequiredArgsConstructor;
import org.example.service.posts.PostsService;
import org.example.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllAsc());
        return "index";     // index.mustache 호출
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";    // posts-save.mustache 호출
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}

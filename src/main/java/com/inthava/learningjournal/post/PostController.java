package com.inthava.learningjournal.post;

import org.springframework.stereotype.Controller;

@Controller
public class PostController {
    PostService postService;
    String redirect = "redirect:/dashboard";

    public PostController(PostService postService) {
        this.postService = postService;
    }


}

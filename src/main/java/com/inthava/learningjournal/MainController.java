package com.inthava.learningjournal;

import com.inthava.learningjournal.post.Post;
import com.inthava.learningjournal.post.PostService;
import com.inthava.learningjournal.user.User;
import com.inthava.learningjournal.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MainController {
    PostService postService;

    UserService userService;

    public MainController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/")
    String homePage(ModelMap modelMap) {
        List<Post> posts = postService.allPost();
        modelMap.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/home")
    String homePage1(ModelMap modelMap) {
        List<Post> posts = postService.allPost();
        modelMap.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/about")
    String aboutPage() {
        return "index";
    }

    @GetMapping("/read/{id}")
    String readPost(@PathVariable("id") Long postId, Model model) {
        Post post = postService.findPostById(postId);
        List<Post> posts = postService.allPost();
        model.addAttribute("post", post);
        model.addAttribute("posts", posts);
        return "post";
    }

    @GetMapping("/login")
    String loginPage(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return "redirect:/dashboard";
        }
        return "login";
    }

    @PostMapping("/login")
    String login(@RequestParam String username,
                 @RequestParam String password,
                 HttpSession session) {

        User user = userService.isValidUser(username, password);
        if (user != null) {
            session.setAttribute("user", user);

            return "redirect:/dashboard";
        }
        return "redirect:/login";

    }

    @GetMapping("/logout")
    String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    String dashboardPage(HttpSession session, ModelMap modelMap) {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            List<Post> posts = postService.allPost();
            modelMap.addAttribute("posts", posts);
            System.out.println(posts.get(1).getTitle());
            return "dashboard";
        }
        return "redirect:/login";
    }

    @GetMapping("/newpost")
    String newPostForm(HttpSession session, ModelMap modelMap) {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            modelMap.addAttribute("post", new Post());
            modelMap.addAttribute("isNewPost", true);
            return "new_post";
        }
        return "redirect:/login";
    }

    @PostMapping("/newpost")
    String newPost(@ModelAttribute("post") Post post, HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            post.setDateCreate(LocalDateTime.now());
            post.setAuthor(user.getUsername());
            post.setStatus("public");
            postService.createPost(post);

            return "redirect:/dashboard";
        }
        return "redirect:/login";
    }

    @GetMapping("/edit/{id}")
    String updatePostForm(@PathVariable Long id, HttpSession session, ModelMap modelMap) {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            modelMap.addAttribute("post", postService.findPostById(id));
            modelMap.addAttribute("isNewPost", false);
            return "new_post";
        }
        return "redirect:/login";
    }

    @GetMapping("/delete/{id}")
    String deletePost(@PathVariable Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            postService.deletePostById(id);
            return "redirect:/dashboard";
        }
        return "redirect:/login";
    }
}

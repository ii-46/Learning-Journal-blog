package com.inthava.learningjournal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningJournalApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningJournalApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(PostService postService, UserService userService) {
//        return args -> {
//
//            Post post = new Post(1L,
//                    "Hello title",
//                    "Inthava",
//                    LocalDateTime.now(),
//
//                    "publish",
//                    "tgs, tags, tags, tags",
//
//                    "Content ContentContentContentContentContent",
//                    "category"
//            );
//
//            postService.createPost(post);
//            post.setId(2L);
//            postService.createPost(post);
//            post.setId(3L);
//            postService.createPost(post);
//            post.setId(4L);
//            postService.createPost(post);
//            User user = new User(
//                    1L,
//                    "ngoum",
//                    "Inthava Xaiyalun",
//                    "inthava@gamil.com",
//                    "dongdok 123",
//                    "efjoeij3123",
//                    LocalDateTime.now(),
//                    "admin"
//            );
////            userService.creatUser(user);
////            System.out.println(userService.isValidUser(user.getUsername(), user.getPassword()));
////            System.out.println(userService.getUserInformation(user.getUsername()));
////            userService.updatePassword(user.getId(), "1234");
//
//        };
//    }

}

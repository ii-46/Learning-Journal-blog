package com.inthava.learningjournal.post;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(Post post) {
        postRepository.save(post);
    }

    public void updatePost(Post post) {
        System.out.println("Update Post: " + postRepository.save(post).getTitle());
    }

    public List<Post> allPost() {
        return postRepository.findAll();
    }

    public List<Post> findPostByTitle(String title) {
        return postRepository.findByTitleContaining(title);
    }

    public Post findPostById(Long id) {
        return postRepository.findById(id).get();
    }

    public List<Post> findPostByAuthor(String author) {
        return postRepository.findByAuthor(author);
    }

    public void deletePostById(Long id) {
        postRepository.removeById(id);
    }
}

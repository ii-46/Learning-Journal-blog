package com.inthava.learningjournal.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthor(String author);

    List<Post> findByTitleContaining(String title);


    @Transactional
    @Modifying
    void removeById(Long id);

}

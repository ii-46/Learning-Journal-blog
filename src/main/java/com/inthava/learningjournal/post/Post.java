package com.inthava.learningjournal.post;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "Post")
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(
            name = "title",
            nullable = false,
            columnDefinition = "varchar(250)"
    )
    private String title;
    @Column(
            name = "author",
            nullable = false,
            columnDefinition = "varchar(250)"
    )
    private String author;

    @Column(
            name = "date_create",
            nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private LocalDateTime dateCreate;

    @Column(
            name = "status",
            nullable = false,
            columnDefinition = "varchar(250)"
    )
    private String status;
    @Column(
            name = "tags",
            nullable = false,
            columnDefinition = "varchar(250)"
    )
    private String tags;

    @Column(
            name = "content",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String content;
    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;
    @Column(
            name = "category",
            nullable = false,
            columnDefinition = "varchar(250)"
    )
    private String category;
    @Column(
            name = "thumbnail",
            columnDefinition = "varchar(250)"
    )
    private String thumbnail;


    public Post() {
    }

    public Post(Long id, String title, String author, LocalDateTime dateCreate, String status, String tags, String content, String description, String category, String thumbnail) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.dateCreate = dateCreate;
        this.status = status;
        this.tags = tags;
        this.content = content;
        this.description = description;
        this.category = category;
        this.thumbnail = thumbnail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(title, post.title) && Objects.equals(author, post.author) && Objects.equals(dateCreate, post.dateCreate) && Objects.equals(status, post.status) && Objects.equals(tags, post.tags) && Objects.equals(content, post.content) && Objects.equals(description, post.description) && Objects.equals(category, post.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, dateCreate, status, tags, content, description, category);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", dateCreate=" + dateCreate +
                ", status='" + status + '\'' +
                ", tags='" + tags + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
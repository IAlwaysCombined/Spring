package com.example.zaicev.repo;

import com.example.zaicev.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findByTitle(String title);
}

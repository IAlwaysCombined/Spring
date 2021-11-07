package com.example.zaicev.repo;

import com.example.zaicev.model.StudentPost;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<StudentPost, Long> {
    List<StudentPost> findByName(String name);
}

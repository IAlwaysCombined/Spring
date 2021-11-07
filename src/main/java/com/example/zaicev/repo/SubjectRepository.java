package com.example.zaicev.repo;

import com.example.zaicev.model.SubjectPost;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubjectRepository extends CrudRepository<SubjectPost, Long> {
    List<SubjectPost> findByNameSubject(String nameSubject);
}

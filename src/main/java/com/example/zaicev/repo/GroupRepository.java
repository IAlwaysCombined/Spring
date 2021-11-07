package com.example.zaicev.repo;

import com.example.zaicev.model.GroupPost;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<GroupPost, Long> {
    List<GroupPost> findByNameGroup(String nameGroup);
}

package com.example.zaicev.repo;

import org.springframework.data.repository.CrudRepository;

public interface Student extends CrudRepository<com.example.zaicev.model.Student, Long> {
    com.example.zaicev.model.Student findByName(String name);
}

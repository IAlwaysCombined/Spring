package com.example.zaicev.repo;

import org.springframework.data.repository.CrudRepository;

public interface University extends CrudRepository<com.example.zaicev.model.University, Long> {
    com.example.zaicev.model.University findByName(String name);
}


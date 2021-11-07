package com.example.zaicev.repo;

import org.springframework.data.repository.CrudRepository;

public interface Person extends CrudRepository<com.example.zaicev.model.Person, Long> {
    com.example.zaicev.model.Person findByName(String name);
}

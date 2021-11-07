package com.example.zaicev.repo;

import com.example.zaicev.model.PersonModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<PersonModel, Long> {
    List<PersonModel> findByName(String name);
}

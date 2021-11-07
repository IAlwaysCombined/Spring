package com.example.zaicev.repo;

import com.example.zaicev.model.Adress;
import org.springframework.data.repository.CrudRepository;

public interface Address extends CrudRepository<Adress, Long> {
    Adress findByStreet(String street);
}

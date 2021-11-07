package com.example.zaicev.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PersonForm {
    @NotEmpty(message = "Ошибка")
    @Size(min = 2, max = 30, message = "Ошибка" )
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

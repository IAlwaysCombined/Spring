package com.example.zaicev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GroupPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameGroup;
    private int count_number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public int getCount_number() {
        return count_number;
    }

    public void setCount_number(int count_number) {
        this.count_number = count_number;
    }

    public GroupPost(String nameGroup, int count_number){
        this.nameGroup = nameGroup;
        this.count_number = count_number;
    }

    public GroupPost(){}
}

package com.example.zaicev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubjectPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameSubject;
    private Long subjectLong;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public Long getSubjectLong() {
        return subjectLong;
    }

    public void setSubjectLong(Long subjectLong) {
        this.subjectLong = subjectLong;
    }

    public SubjectPost(String nameSubject, Long subjectLong) {
        this.nameSubject = nameSubject;
        this.subjectLong = subjectLong;
    }

    public SubjectPost() {
    }
}

package com.oocl.web.sampleWebApp.jpaSample.entity;

import javax.persistence.*;

@Entity
public class Single {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    @Column(length = 64,nullable = false)
    private String name;

    private String age;

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setName(String test) {
        this.name = test;
    }

    public String getName() {
        return name;
    }
}

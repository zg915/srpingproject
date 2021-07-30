package com.primeton.springproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "product")
@DynamicUpdate
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "releasetime")
    private Date releaseTime;

    public Product() {
    }

    public Product(Integer id, String name, String description, Date releaseTime) {
        Id = id;
        this.name = name;
        this.description = description;
        this.releaseTime = releaseTime;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseTime() { return releaseTime; }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }
}

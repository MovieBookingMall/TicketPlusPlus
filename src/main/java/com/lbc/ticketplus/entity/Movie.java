package com.lbc.ticketplus.entity;

import java.math.BigDecimal;

public class Movie {
    private Integer id;

    private String name;

    private BigDecimal price;

    private String tag;

    private String intro;

    private String director;

    private String actor;

    private String area;

    public Movie(String name, BigDecimal price, String tag, String intro, String director, String actor, String area) {
        this.name = name;
        this.price = price;
        this.tag = tag;
        this.intro = intro;
        this.director = director;
        this.actor = actor;
        this.area = area;
    }

    public Movie(Integer id, String name, BigDecimal price, String tag, String intro, String director, String actor, String area) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.tag = tag;
        this.intro = intro;
        this.director = director;
        this.actor = actor;
        this.area = area;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor == null ? null : actor.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }
}
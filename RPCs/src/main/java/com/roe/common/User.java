package com.roe.common;

import java.io.Serializable;

/**
 * @Auther: HP
 * @Date: 2021/1/3 16:33
 * @Description:
 **/

public class User implements Serializable {
    private Integer id;
    private String name;

    public User() {
    }

    public User(Integer id, String name) {
        this.name = name;
        this.id = id;
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
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

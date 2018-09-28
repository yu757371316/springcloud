package com.example.common.dto;

import java.util.StringJoiner;

/**
 * @author :  20160301301
 * @date : 2018/9/28 16:47
 */
public class Use {
    private String name;
    private int age;

    public Use() { }

    public Use(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Use.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

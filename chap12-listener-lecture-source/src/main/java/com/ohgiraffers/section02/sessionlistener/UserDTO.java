package com.ohgiraffers.section02.sessionlistener;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class UserDTO implements HttpSessionBindingListener {

    private String name;
    private int age;

    public UserDTO() {
    }

    public UserDTO(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // 해당 클래스로 만든 인스턴스가 세션에 바인딩(값이 추가) 되는 경우 동작한다.
        System.out.println("value bound!");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        // 해당 클래스로 만든 인스턴스가 세션에 바인딩 해제
        // 값제거 또는 세션이 만료 되는 경우 동작한다.
        System.out.println("value unbound!");
    }
}

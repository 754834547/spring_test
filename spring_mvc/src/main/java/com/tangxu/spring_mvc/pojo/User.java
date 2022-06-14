package com.tangxu.spring_mvc.pojo;

public class User {
    private String userName;
    private int age;
    private String phone;

    @Override
    public String toString() {
        return "user{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

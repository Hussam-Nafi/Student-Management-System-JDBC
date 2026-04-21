package com.hussam.model;

import java.sql.Date;

public class Student {
    private int id;
    private String name;
    private String email;
    private String phone;
    private Date birthday;
    private int firstMark;
    private int secondMark;
    private int finalMark;

    public Student() {}

    public Student(int id, String name, String email, String phone, Date birthday, int firstMark, int secondMark, int finalMark) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.firstMark = firstMark;
        this.secondMark = secondMark;
        this.finalMark = finalMark;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getFirstMark() {
        return firstMark;
    }

    public int getSecondMark() {
        return secondMark;
    }

    public int getFinalMark() {
        return finalMark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", firstMark=" + firstMark +
                ", secondMark=" + secondMark +
                ", finalMark=" + finalMark +
                '}';
    }
}

package com.example.baitaponlistviewjson1;

import java.util.Arrays;

public class InfoPersons {
    private String fullname;
    private int gender;
    private int age;
    private String level;
    private String monthlysalary;
    boolean [] interest;

    public InfoPersons() {
    }
    public InfoPersons(String fullname, int gender, int age, String level, String monthlysalary, boolean []interest) {
        this.fullname = fullname;
        this.gender = gender;
        this.age = age;
        this.level = level;
        this.monthlysalary = monthlysalary;
        this.interest = interest;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMonthlysalary() {
        return monthlysalary;
    }

    public void setMonthlysalary(String monthlysalary) {
        this.monthlysalary = monthlysalary;
    }

    public boolean[] getInterest() {
        return interest;
    }

    public void setInterest(boolean[] interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "InfoPerson{" +
                "fullname='" + fullname + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", level='" + level + '\'' +
                ", monthlysalary='" + monthlysalary + '\''
                ;
    }
}

package com.example.demo_json;

public class Person {
    private String fullname;
    private int gender;
    private int age;
    private String level;
    private String monthly_salary;
    private Interests interests;

    public class Interests {
        private boolean soccer;
        private boolean swim;
        private boolean badminton;

        // Getters and Setters for Interests class
        public boolean isSoccer() {
            return soccer;
        }

        public void setSoccer(boolean soccer) {
            this.soccer = soccer;
        }

        public boolean isSwim() {
            return swim;
        }

        public void setSwim(boolean swim) {
            this.swim = swim;
        }

        public boolean isBadminton() {
            return badminton;
        }

        public void setBadminton(boolean badminton) {
            this.badminton = badminton;
        }
    }

    // Getters and Setters for Person class
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

    public String getMonthly_salary() {
        return monthly_salary;
    }

    public void setMonthly_salary(String monthly_salary) {
        this.monthly_salary = monthly_salary;
    }

    public Interests getInterests() {
        return interests;
    }

    public void setInterests(Interests interests) {
        this.interests = interests;
    }
}

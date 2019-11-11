package com.kodilla.good.patterns.challenges;

public class User {
    private String firstName;
    private String lastName;
    private String nickName;

    public User(String firstName, String lastName, String nickName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }
}

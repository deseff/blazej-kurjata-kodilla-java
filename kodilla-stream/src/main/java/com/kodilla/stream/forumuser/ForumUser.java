package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int uniqueUserID;
    private final String userName;
    private final char sex;
    private final LocalDate birthDate;
    private final int numberOfPostsPublished;

    public ForumUser(final int uniqueUserID, final String userName, final char sex, final LocalDate birthDate, final int numberOfPostsPublished) {
        this.uniqueUserID = uniqueUserID;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.numberOfPostsPublished = numberOfPostsPublished;
    }

    public int getUniqueUserID() {
        return uniqueUserID;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getNumberOfPostsPublished() {
        return numberOfPostsPublished;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "uniqueUserID=" + uniqueUserID +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", numberOfPostsPublished=" + numberOfPostsPublished +
                '}';
    }
}

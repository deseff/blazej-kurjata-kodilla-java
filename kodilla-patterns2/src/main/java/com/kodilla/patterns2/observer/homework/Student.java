package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Student implements Observable {
    private final String surname;
    private final List<Observer> observers;
    private Map<String, String> homeworks;
    private final KodillaCourses courseName;

    public Student(String surname, KodillaCourses courseName) {
        this.surname = surname;
        observers = new ArrayList<>();
        homeworks = new LinkedHashMap<>();
        this.courseName = courseName;
    }

    public void addHomework(String homeworkNumber, String answer) {
        homeworks.put(homeworkNumber, answer);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public String getSurname() {
        return surname;
    }

    public Map<String, String> getHomeworks() {
        return homeworks;
    }

    public KodillaCourses getCourseName() {
        return courseName;
    }
}

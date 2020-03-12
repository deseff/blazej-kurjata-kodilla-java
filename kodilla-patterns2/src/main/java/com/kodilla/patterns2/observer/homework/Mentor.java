package com.kodilla.patterns2.observer.homework;

import java.util.Map;

public class Mentor implements Observer {
    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(Student student) {
        Map<String, String> homework = student.getHomeworks();
        String lastKey = "";
        for (String entry : homework.keySet()) {
            lastKey=entry;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Student ");
        sb.append(student.getSurname());
        sb.append(" from ");
        sb.append(student.getCourseName());
        sb.append(" course send new homework:\n");
        sb.append(lastKey);
        System.out.println(sb);
        updateCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}

package com.kodilla.patterns2.observer.homework;

import org.junit.Assert;
import org.junit.Test;

public class HomeworkTestSuite {
    @Test
    public void testUpdateHomeworks(){
        //Given
        Student piotrSchmit = new Student("Piotr Schmit", KodillaCourses.JAVA_DEVELOPER);
        Student adamZielinski  =new Student("Adam Zieliński", KodillaCourses.PYTHON_DEVELOPER);
        Student adamOstrowski = new Student("Adam Ostrowski", KodillaCourses.WEB_DEVELOPER);

        Mentor tomaszStanko = new Mentor("Tomasz Stańko");
        Mentor michalUrbanski = new Mentor("Michał Urbański");
        Mentor urszulaDudziak = new Mentor("Urszula Dudziak");


        piotrSchmit.registerObserver(tomaszStanko);
        adamZielinski.registerObserver(michalUrbanski);
        adamOstrowski.registerObserver(urszulaDudziak);

        //When
        piotrSchmit.addHomework("6.4", "ShapeCollector");
        adamZielinski.addHomework("3.1","Conditionals and Control Flow");
        adamOstrowski.addHomework("1.1","index.html");
        piotrSchmit.addHomework("6.5", "Book library with mock");

        //Then
        Assert.assertEquals(2,tomaszStanko.getUpdateCount());
        Assert.assertEquals(1,michalUrbanski.getUpdateCount());
        Assert.assertEquals(1,urszulaDudziak.getUpdateCount());
    }
}

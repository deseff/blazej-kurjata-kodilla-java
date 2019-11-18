package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        TaskList toDoList = board.getToDoList();
        TaskList inProgressList = board.getInProgressList();
        TaskList doneList = board.getDoneList();

        toDoList.getTasks().add("To do task");
        inProgressList.getTasks().add("In progress task");
        doneList.getTasks().add("Done task");
        //Then
        Assert.assertEquals(toDoList.getTasks().get(0), "To do task");
        Assert.assertEquals(inProgressList.getTasks().get(0), "In progress task");
        Assert.assertEquals(doneList.getTasks().get(0), "Done task");
    }
}

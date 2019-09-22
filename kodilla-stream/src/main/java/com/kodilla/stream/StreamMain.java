package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.person.People;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        /*System.out.println("Welcome to module 7 - Stream");

        SaySomething saySomething = new SaySomething();
        saySomething.say();*/

        /*Processor processor = new Processor();
        //ExecuteSaySomething executeSaySomething = new ExecuteSaySomething(); - not lambda
        Executor codeToExecute = () -> System.out.println("This is an example text"); //lambda
        //processor.execute(executeSaySomething); - not lambda
        processor.execute(codeToExecute); //lambda*/


        //next example
        /*ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);*/

        //Module 7.1 - task
        /*PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("What a beautiful world", text -> "ABC" + text + "ABC");
        poemBeautifier.beautify("Biological hazard", text -> text.toUpperCase());
        poemBeautifier.beautify("Not important content", text -> text.toLowerCase());
        poemBeautifier.beautify("This is very important", text -> text + "!!!");

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

        //Module 7.3. task form the theory
        People.getList().stream()
//                .map(s -> s.toUpperCase())
//                .forEach(System.out::println)
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(s -> System.out.println(s));*/

        //class Book in package Book
        /*BookDirectory theBookDirectory = new BookDirectory();
//        theBookDirectory.getList().stream()
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());
//                .forEach(System.out::println);
//                .forEach(book -> System.out.println(book));
        System.out.println("# elements:" + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);*/

        /*BookDirectory theBookDirectory = new BookDirectory();

        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);*/

        /*BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));
        System.out.println(theResultStringOfBooks);*/

        //Module 7.3 - task
        Forum theForum = new Forum();
        Map<String, ForumUser> theResultMapOfUsers = theForum.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> user.getBirthDate() - LocalDate.now() => 20)
                .filter(user -> user.getNumberOfPostsPublished() => 1)
                .collect(Collectors.toMap(ForumUser::getUniqueUserID, user -> user))
                .forEach(System.out::println);

    }
}


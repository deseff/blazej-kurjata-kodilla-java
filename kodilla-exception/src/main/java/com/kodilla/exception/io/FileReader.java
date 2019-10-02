package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    public void readFile() throws FileReaderException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());
        //Path path = Paths.get(file.getPath()); //
        //Path path = Paths.get("files/test.txt"); //intentional error

        /*------------below----------
         *try {
         *Stream<String> fileLines = Files.lines(path);
         * }
         *----------changed into:
        try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath()))) {*/


        try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath()))) {
        //try (Stream<String> fileLines = Files.lines(Paths.get("files/test.txt"))) { //intentional error
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            throw new FileReaderException();
            //System.out.println("Oh no! Something went wrong! Error:" + e);
        } finally {
            System.out.println("I'm gonna be here... always");
        }

        System.out.println(file.getPath());
    }
}

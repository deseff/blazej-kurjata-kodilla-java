package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Local library");
        //creating books
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> library.getBooks().add(new Book("Book number" + n,
                        "Author " + n * 10,
                        LocalDate.of(2019, n, n * 2))));

        //creating a shallow copy of library
        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("City library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //creating a deep copy of library
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("National library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().add(new Book("Title", "Author", LocalDate.of(2019, 11, 23)));

        //Then
        System.out.println(library);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(11, library.getBooks().size());
        Assert.assertEquals(11, shallowClonedLibrary.getBooks().size());
        Assert.assertEquals(10, deepClonedLibrary.getBooks().size());
    }
}

package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Statistics;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter(new Statistics());
        Set<Book> bookA = new HashSet<>();
        bookA.add(new Book("Tom Clancy",
                "The Hunt for Red October",
                1990,
                "978-83-240-5701-6"));
        bookA.add(new Book("Frederick Forsyth",
                "The Afghan",
                2006,
                "978-83-812-5669-8"));
        bookA.add(new Book("Stieg Larsson",
                "Men who hate women",
                2005,
                "978-83-755-4081-9"));
        bookA.add(new Book("Carlos Ruiz Zafón",
                "Shadow of the wind",
                2005,
                "978-83-287-0886-0"));

        //When
        double median = medianAdapter.publicationYearMedian(bookA);

        //Then
        Assert.assertEquals(2005, median, 0);
    }
}

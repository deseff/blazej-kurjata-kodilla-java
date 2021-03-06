package com.kodilla.testing.library;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title" + n, "Author" + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");
        //Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);
        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        //Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf10Books);
        //When
        List<Book> theListOf10Books = bookLibrary.listBooksWithCondition("An");
        //Then
        assertEquals(0, theListOf10Books.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOfWithZeroBooksBorrowed() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("F", "L", "666666");
        List<Book> borrowed0Books = new ArrayList<>();
        when(libraryDatabaseMock.listBookInHandsOf(libraryUser)).thenReturn(borrowed0Books);
        //When
        List<Book> listOf0Books = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        assertEquals(0, listOf0Books.size());
        verify(libraryDatabaseMock, times(1)).listBookInHandsOf(libraryUser);
    }

    @Test
    public void testListBooksInHandsOfWithOneBookBorrowed() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        LibraryUser libraryUser = new LibraryUser("F", "L", "666666");
        List<Book> borrowed1Book = generateListOfNBooks(1);
        when(libraryDatabaseMock.listBookInHandsOf(libraryUser)).thenReturn(borrowed1Book);
        //When
        List<Book> listOf1Book = libraryDatabaseMock.listBookInHandsOf(libraryUser);
        //Then
        assertEquals(1, listOf1Book.size());
        verify(libraryDatabaseMock, times(1)).listBookInHandsOf(libraryUser);
    }

    @Test
    public void testListBooksInHandsOfWithFiveBooksBorrowed() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        LibraryUser libraryUser = new LibraryUser("F", "L", "66666");
        List<Book> borrowed5Books = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBookInHandsOf(libraryUser)).thenReturn(borrowed5Books);
        //When
        List<Book> listOf5Books = libraryDatabaseMock.listBookInHandsOf(libraryUser);
        //Then
        assertEquals(5, listOf5Books.size());
        verify(libraryDatabaseMock, times(1)).listBookInHandsOf(libraryUser);
    }
}

package io.degreat.bookApplication.Service.Iservice;

import io.degreat.bookApplication.Model.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);

    List<Book> findAllBooks();

    void deleteBook(Long bookId);

//    just implemented this both in the book service and its implementation
    Book updateBook(Book book);
}

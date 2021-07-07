package org.example.services;

import org.example.entity.Book;
import java.util.List;

public interface BookService {
    List<Book> getBooks();
    void saveBook(Book book);
    Book getBook(int book_id);
    void deleteBook(int book_id);
}

package org.example.dao;

import org.example.entity.Book;
import java.util.List;

public interface BookDAO {
    List<Book> getBooks();
    void saveBook(Book book);
    Book getBook(int book_id);
    void deleteBook(int book_id);
}

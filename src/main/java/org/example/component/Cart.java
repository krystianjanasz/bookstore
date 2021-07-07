package org.example.component;

import org.example.entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Component
@SessionScope
public class Cart {
    private Set<Book> books = new HashSet<>();
    public void addBookId(Book book) {
        books.add(book);
    }
    public void deleteBookId(Book book) {
        Iterator i = books.iterator();
        Book b = new Book();
        while (i.hasNext()) {
            b = (Book)i.next();
            if (b.getId() == book.getId()) {
                i.remove();
                break;
            }
        }
//        books.remove(book);
    }
    public Set<Book> getBooks() {
        return books;
    }
}
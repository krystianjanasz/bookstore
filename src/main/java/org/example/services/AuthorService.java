package org.example.services;

import org.example.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthors();
    void saveAuthor(Author author);
    Author getAuthor(int author_id);
    void deleteAuthor(int author_id);
}

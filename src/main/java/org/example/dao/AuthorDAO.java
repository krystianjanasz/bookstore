package org.example.dao;

import org.example.entity.Author;

import java.util.List;

public interface AuthorDAO {
    List<Author> getAuthors();
    void saveAuthor(Author author);
    Author getAuthor(int author_id);
    void deleteAuthor(int author_id);
}

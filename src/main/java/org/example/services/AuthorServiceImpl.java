package org.example.services;

import org.example.dao.AuthorDAO;
import org.example.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    @Transactional
    public List<Author> getAuthors() {
        return authorDAO.getAuthors();
    }

    @Override
    @Transactional
    public void saveAuthor(Author author) {
        authorDAO.saveAuthor(author);
    }

    @Override
    @Transactional
    public Author getAuthor(int author_id) {
        return authorDAO.getAuthor(author_id);
    }

    @Override
    @Transactional
    public void deleteAuthor(int author_id) {
        authorDAO.deleteAuthor(author_id);
    }
}

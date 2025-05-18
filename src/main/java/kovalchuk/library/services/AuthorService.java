package kovalchuk.library.services;

import kovalchuk.library.models.Author;
import kovalchuk.library.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(long id) {
        Optional<Author> author = authorRepository.findById(id);
        return author.orElse(null);
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }
}

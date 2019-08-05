package br.com.personal.webhookreceiver.service;

import br.com.personal.webhookreceiver.model.Author;
import br.com.personal.webhookreceiver.model.Commit;
import br.com.personal.webhookreceiver.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void saveAuthorIfNotExist(Commit commit) {
        Author author = authorRepository.findAuthorByEmail(commit.getAuthor().getEmail());

        if (author == null) {
            authorRepository.save(commit.getAuthor());
        } else {
            commit.getAuthor().setId(author.getId());
        }
    }
}

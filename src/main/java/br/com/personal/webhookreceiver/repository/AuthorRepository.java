package br.com.personal.webhookreceiver.repository;

import br.com.personal.webhookreceiver.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findAuthorByEmail(String email);
}

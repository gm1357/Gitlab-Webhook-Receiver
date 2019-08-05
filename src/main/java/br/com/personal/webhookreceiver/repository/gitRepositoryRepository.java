package br.com.personal.webhookreceiver.repository;

import br.com.personal.webhookreceiver.model.gitRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface gitRepositoryRepository extends CrudRepository<gitRepository, Long> {

    gitRepository findByUrl(String url);
}

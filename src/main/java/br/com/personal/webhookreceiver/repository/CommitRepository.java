package br.com.personal.webhookreceiver.repository;

import br.com.personal.webhookreceiver.model.Commit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommitRepository extends CrudRepository<Commit, Long> {
}

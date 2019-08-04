package br.com.personal.webhookreceiver.repository;

import br.com.personal.webhookreceiver.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}

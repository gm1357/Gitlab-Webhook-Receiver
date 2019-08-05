package br.com.personal.webhookreceiver.service;

import br.com.personal.webhookreceiver.model.PushEvent;
import br.com.personal.webhookreceiver.model.gitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GitRepositoryService {

    @Autowired
    private br.com.personal.webhookreceiver.repository.gitRepositoryRepository gitRepositoryRepository;

    public void saveRepositoryIfNotExist(PushEvent push) {
        gitRepository repository = gitRepositoryRepository.findByUrl(push.getRepository().getUrl());

        if (repository == null) {
            gitRepositoryRepository.save(push.getRepository());
        } else {
            push.getRepository().setId(repository.getId());
        }
    }
}

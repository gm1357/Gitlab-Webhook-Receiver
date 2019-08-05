package br.com.personal.webhookreceiver.service;

import br.com.personal.webhookreceiver.model.Author;
import br.com.personal.webhookreceiver.model.PushEvent;
import br.com.personal.webhookreceiver.model.gitRepository;
import br.com.personal.webhookreceiver.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@Service
public class WebhookService {

    @Autowired
    private PushEventRepository pushEventRepository;

    @Autowired
    private gitRepositoryRepository gitRepositoryRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private CommitRepository commitRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public void saveInDataBase(PushEvent push) {
        if (!projectRepository.existsById(push.getProject().getId())) {
            projectRepository.save(push.getProject());
        }

        push.getCommits().forEach(commit -> {
            Author author = authorRepository.findAuthorByEmail(commit.getAuthor().getEmail());

            if (author == null) {
                authorRepository.save(commit.getAuthor());
            } else {
                commit.getAuthor().setId(author.getId());
            }

            commitRepository.save(commit);
        });

        gitRepository repository = gitRepositoryRepository.findByUrl(push.getRepository().getUrl());

        if (repository == null) {
            gitRepositoryRepository.save(push.getRepository());
        } else {
            push.getRepository().setId(repository.getId());
        }

        pushEventRepository.save(push);
    }

    public PushEvent getPushEvent(@RequestBody String jsonString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, PushEvent.class);
    }
}

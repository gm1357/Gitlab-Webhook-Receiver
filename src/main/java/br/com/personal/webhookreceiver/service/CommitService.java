package br.com.personal.webhookreceiver.service;

import br.com.personal.webhookreceiver.model.PushEvent;
import br.com.personal.webhookreceiver.repository.CommitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommitService {

    @Autowired
    private CommitRepository commitRepository;

    @Autowired
    private AuthorService authorService;

    public void saveCommits(PushEvent push) {
        push.getCommits().forEach(commit -> {

            authorService.saveAuthorIfNotExist(commit);
            commitRepository.save(commit);
        });
    }
}

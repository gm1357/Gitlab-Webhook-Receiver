package br.com.personal.webhookreceiver.service;

import br.com.personal.webhookreceiver.model.PushEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@Service
public class WebhookService {

    @Autowired
    private GitRepositoryService gitRepositoryService;

    @Autowired
    private PushEventService pushEventService;

    @Autowired
    private  CommitService commitService;

    @Autowired
    private ProjectService projectService;

    @Async
    public void saveInDataBase(PushEvent push) {

        projectService.saveProjectIfNotExist(push);
        commitService.saveCommits(push);
        gitRepositoryService.saveRepositoryIfNotExist(push);
        pushEventService.savePushEvent(push);
    }

    public PushEvent getPushEvent(@RequestBody String jsonString) throws IOException {
        return pushEventService.getPushEvent(jsonString);
    }
}

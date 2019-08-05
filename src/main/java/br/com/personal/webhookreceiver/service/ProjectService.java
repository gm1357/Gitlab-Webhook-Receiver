package br.com.personal.webhookreceiver.service;

import br.com.personal.webhookreceiver.model.PushEvent;
import br.com.personal.webhookreceiver.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public void saveProjectIfNotExist(PushEvent push) {
        if (!projectRepository.existsById(push.getProject().getId())) {
            projectRepository.save(push.getProject());
        }
    }
}

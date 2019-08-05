package br.com.personal.webhookreceiver.service;

import br.com.personal.webhookreceiver.model.PushEvent;
import br.com.personal.webhookreceiver.repository.PushEventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@Service
public class PushEventService {

    @Autowired
    private PushEventRepository pushEventRepository;

    public void savePushEvent(PushEvent push) {
        pushEventRepository.save(push);
    }

    public PushEvent getPushEvent(@RequestBody String jsonString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, PushEvent.class);
    }
}

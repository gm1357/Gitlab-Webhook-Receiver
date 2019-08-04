package br.com.personal.webhookreceiver.controller;

import br.com.personal.webhookreceiver.model.Author;
import br.com.personal.webhookreceiver.model.Commit;
import br.com.personal.webhookreceiver.model.PushEvent;
import br.com.personal.webhookreceiver.repository.AuthorRepository;
import br.com.personal.webhookreceiver.repository.CommitRepository;
import br.com.personal.webhookreceiver.repository.ProjectRepository;
import br.com.personal.webhookreceiver.repository.PushEventRepository;
import br.com.personal.webhookreceiver.service.WebhookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class WebhookController {

    @Autowired
    private WebhookService webhookService;

    @PostMapping("/")
    @ResponseBody
    public HttpStatus receiver(@RequestBody String jsonString) {
        System.out.println("WebHook recebido!");
        System.out.println(jsonString);

        try {
            PushEvent push = webhookService.getPushEvent(jsonString);
            webhookService.saveInDataBase(push);

        } catch (IOException e) {
            e.printStackTrace();
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return HttpStatus.OK;
    }

    @PostMapping("/tag")
    @ResponseBody
    public HttpStatus receiverTag(@RequestBody String jsonString) {
        System.out.println(jsonString);

        return HttpStatus.OK;
    }
}

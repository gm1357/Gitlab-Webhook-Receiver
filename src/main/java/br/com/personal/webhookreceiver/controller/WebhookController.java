package br.com.personal.webhookreceiver.controller;

import br.com.personal.webhookreceiver.model.PushEvent;
import br.com.personal.webhookreceiver.service.EmailService;
import br.com.personal.webhookreceiver.service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

import static java.time.LocalDate.now;

@Controller
public class WebhookController {

    @Autowired
    private WebhookService webhookService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity receiver(@RequestBody String jsonString) {
        System.out.println(jsonString);

        try {
            PushEvent push = webhookService.getPushEvent(jsonString);
            webhookService.saveInDataBase(push);
            emailService.sendNotificationEmail(push);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }

        return ResponseEntity.ok(now());
    }

    @PostMapping("/tag")
    @ResponseBody
    public ResponseEntity receiverTag(@RequestBody String jsonString) {
        System.out.println(jsonString);

        return ResponseEntity.ok(now());
    }
}

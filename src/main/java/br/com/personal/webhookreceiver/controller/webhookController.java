package br.com.personal.webhookreceiver.controller;

import br.com.personal.webhookreceiver.model.Commit;
import br.com.personal.webhookreceiver.model.PushEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class webhookController {

    @GetMapping("/")
    @ResponseBody
    public String webhook() {
        return "teste";
    }

    @PostMapping("/")
    @ResponseBody
    public HttpStatus receiver(@RequestBody String jsonString) {
        System.out.println("WebHook recebido!");
        System.out.println(jsonString);

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            PushEvent push = objectMapper.readValue(jsonString, PushEvent.class);

            System.out.println(push.getProject().getName());

            for (Commit commit : push.getCommits()) {
                System.out.println(commit.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
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

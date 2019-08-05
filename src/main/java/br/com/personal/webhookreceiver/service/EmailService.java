package br.com.personal.webhookreceiver.service;

import br.com.personal.webhookreceiver.model.PushEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${email.to}")
    private String emailTo;

    @Async
    public void sendNotificationEmail(PushEvent push) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(emailTo);

        msg.setSubject("Novo push feito no projeto " + push.getProject().getName());

        StringBuilder message = new StringBuilder();

        message.append("Um novo push com ").append(push.getTotalCommits().toString()).append(" commits foi feito \n");
        message.append("\n");
        message.append("Projeto: ").append(push.getProject().getName()).append("\n");
        message.append("Usuário: ").append(push.getUserName()).append(" - ").append(push.getUserFullName()).append("\n");
        message.append("Commits (limitado aos 20 primeiros): \n\n");

        push.getCommits().forEach(commit ->
            message.append(commit.getMessage()).append(" - ").append(commit.getTimestamp().toString()).append("\n")
        );

        msg.setText(message.toString());

        javaMailSender.send(msg);
    }

}

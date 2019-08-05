# Gitlab-Webhook-Receiver
> Webhook to integrate with your gitlab repository to persist data and notify by email

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

Firstly you need to change the configuration on the `aplication.properties` file to correspond to you database, smtp information and the email to receive the message.

Then, you can either:

 - Execute the `main` method in the `br.com.personal.webhookreceiver.WebhookReceiverApplication.java` class from your IDE.

 - Or use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Integrating with Gitlab

To integrate with a gitlab repository first you need to expose your application to be accessed from outside your network. An easy way to do that is to use [ngrok](https://ngrok.com/).

Then, in the settings > integrations of you gitlab repository you need to add the url of your server, mark the push event trigger and add webhook.

You can test the webhook by doing a push to the repository or simply by using the test function in the integrations page (your project should have at least one commit).

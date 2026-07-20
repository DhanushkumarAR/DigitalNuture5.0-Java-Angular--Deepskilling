package springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MessageService emailService() {
        return new EmailService();
    }

    // Demonstrating Constructor Injection
    @Bean
    public NotificationService constructorInjectedNotificationService() {
        // Injecting emailService and a string literal via constructor
        return new NotificationService(emailService(), "Constructor-Injected Notification");
    }

    // Demonstrating Setter Injection
    @Bean
    public NotificationService setterInjectedNotificationService() {
        NotificationService service = new NotificationService();
        service.setMessageService(emailService()); // Injecting emailService via setter
        // Note: For setter injection, if the constructor doesn't set notificationType,
        // it would be null unless set via a setter as well.
        // For simplicity, we'll assume the default constructor is used and messageService is set.
        return service;
    }
}

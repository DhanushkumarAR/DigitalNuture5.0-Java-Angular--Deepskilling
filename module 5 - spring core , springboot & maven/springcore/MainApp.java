package springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Exercise 1: Configuring a Basic Spring Application
        // Exercise 5: Configuring the Spring IoC Container (using JavaConfig)

        // Load Spring configuration from the SpringConfig class
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        // Exercise 2: Implementing Dependency Injection
        // Exercise 7: Implementing Constructor and Setter Injection

        // Get the NotificationService bean that was constructor-injected
        NotificationService constructorService = context.getBean("constructorInjectedNotificationService", NotificationService.class);
        System.out.println("--- Constructor Injection Example ---");
        constructorService.sendNotification();

        System.out.println("\n--- Setter Injection Example ---");
        // Get the NotificationService bean that was setter-injected
        // Note: The notificationType for this bean will be null as it's not set via constructor or a specific setter in SpringConfig
        NotificationService setterService = context.getBean("setterInjectedNotificationService", NotificationService.class);
        setterService.sendNotification();
    }
}

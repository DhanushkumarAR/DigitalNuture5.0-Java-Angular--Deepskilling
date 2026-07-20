package springcore;

public class NotificationService {

    private MessageService messageService; // For setter injection
    private String notificationType; // For constructor injection example

    // Constructor for constructor injection
    public NotificationService(MessageService messageService, String notificationType) {
        this.messageService = messageService;
        this.notificationType = notificationType;
    }

    // Default constructor for setter injection if needed, or if no constructor args
    public NotificationService() {
    }

    // Setter for setter injection
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void sendNotification() {
        System.out.println("Notification Type: " + notificationType);
        System.out.println(messageService.getMessage());
    }
}

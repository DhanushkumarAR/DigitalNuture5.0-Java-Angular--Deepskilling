// DependencyInjectionPattern.java

// Service interface
interface MessageService {
    void sendMessage(String msg, String rec);
}

// Concrete Service
class EmailService implements MessageService {
    @Override
    public void sendMessage(String msg, String rec) {
        System.out.println("Email sent to " + rec + " with message=" + msg);
    }
}

// Client class
class MyDIApplication {
    private MessageService service;

    public MyDIApplication(MessageService svc) {
        this.service = svc;
    }

    public void processMessages(String msg, String rec) {
        // Do some msg validation, manipulation logic etc
        this.service.sendMessage(msg, rec);
    }
}

// Injector
class MessageServiceInjector {
    public MyDIApplication getClient() {
        return new MyDIApplication(new EmailService());
    }
}

public class DependencyInjectionPattern {
    public static void main(String[] args) {
        String msg = "Hi Pankaj";
        String email = "pankaj@abc.com";
        MessageServiceInjector injector = new MessageServiceInjector();
        MyDIApplication app = injector.getClient();
        app.processMessages(msg, email);
    }
}

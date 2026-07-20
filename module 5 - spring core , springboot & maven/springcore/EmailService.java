package springcore;

public class EmailService implements MessageService {
    @Override
    public String getMessage() {
        return "Email Service: Sending email message.";
    }
}

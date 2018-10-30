package service.impl.email;

import model.User;
import org.springframework.stereotype.Service;

@Service
public class RegistrationBuilder extends EmailBuilderImpl<User> {

    private static final String SUBJECT = "Registration";

    String getRecipient(User user) {
        return user.getEmail();
    }

    String getSubject() {
        return SUBJECT;
    }

    String getMessageBody(User user) {
        return "Dear "
                + user.getName()
                + " "
                + "Welcome with email"
                + " "
                + user.getEmail();
    }
}

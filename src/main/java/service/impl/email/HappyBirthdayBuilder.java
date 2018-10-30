package service.impl.email;

import model.User;
import org.springframework.stereotype.Service;

@Service
public class HappyBirthdayBuilder extends EmailBuilderImpl<User> {

    private static final String SUBJECT = "Happy Birthday";

    String getRecipient(User user) {
        return user.getEmail();
    }

    String getSubject() {
        return SUBJECT;
    }

    String getMessageBody(User user) {
        return "Dear"
                + " "
                + user.getName()
                + " Happy Birthday!!!";
    }
}

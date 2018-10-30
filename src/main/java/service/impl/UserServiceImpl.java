package service.impl;

import lombok.val;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import service.EmailBuilder;
import service.EmailService;
import service.UserService;
import service.impl.email.EmailBuilderImpl;
import sun.util.resources.LocaleData;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EmailService emailService;
    @Qualifier("registrationBuilder")
    @Autowired
    private EmailBuilder<User> registrationEmailBuilder;
    @Qualifier("happyBirthdayBuilder")
    @Autowired
    private EmailBuilder<User> happyBirthdayEmailBuilder;


    public User save(User user) {

        //save to db

        val message = registrationEmailBuilder.buildMessage(user);
        emailService.sendMessage(message);

        return null;
    }

    public void checkForBirthday() {
        //

        final User user = new User();
        val message = happyBirthdayEmailBuilder.buildMessage(user);
        emailService.sendMessage(message);
    }
}

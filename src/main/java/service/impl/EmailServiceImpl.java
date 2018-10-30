package service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.EmailService;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    @Autowired
    private final JavaMailSender javaMailSender;

    public void sendMessage(@NonNull SimpleMailMessage message) {
        if ("".equals(message.getText())) {
            throw new RuntimeException("message is empty");
        }
        this.javaMailSender.send(message);
    }
}

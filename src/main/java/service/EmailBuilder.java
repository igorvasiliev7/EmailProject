package service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailBuilder<T> {

    SimpleMailMessage buildMessage(T entity);
}

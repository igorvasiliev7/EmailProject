package service.impl.email;

import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.util.Assert;
import service.EmailBuilder;

@PropertySource("classpath:email.properties")
public abstract class EmailBuilderImpl<T> implements EmailBuilder<T> {

    @Value("${mail.sender}")
    private String sender;

    public SimpleMailMessage buildMessage(T entity) {
        Assert.notNull(entity, "entity is null");
        val message = new SimpleMailMessage();
        message.setTo(this.getRecipient(entity));
        message.setFrom(this.sender);
        message.setSubject(this.getSubject());
        message.setText(this.getMessageBody(entity));
        return null;
    }

    abstract String getRecipient(T entity);

    abstract String getSubject();

    abstract String getMessageBody(T entity);
}

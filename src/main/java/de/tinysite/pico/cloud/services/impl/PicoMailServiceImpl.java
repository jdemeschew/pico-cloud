package de.tinysite.pico.cloud.services.impl;

import de.tinysite.pico.cloud.services.PicoMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class PicoMailServiceImpl implements PicoMailService {
    @Value("${pico-site.config-file.template.location}")
    private String picoConfigFileTemplateLocation="";
    @Value("${send-invitation-mail:false}")
    private Boolean sendMails=false;
    @Value("${pico.mail.from:flufl-mail@tinysite.de}")
    private String picoMailFom="";
    Logger logger = LoggerFactory.getLogger(PicoMailServiceImpl.class);

    @Autowired(required = false)
    JavaMailSender mailSender;







    @Override
    public void send(String emailAddress, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(picoMailFom);
        message.setTo(emailAddress);
        message.setSubject(subject);
        message.setText(content);
        if (sendMails) {
            mailSender.send(message);
            logger.info("Sent mail to {}", emailAddress);
        }

    }
}

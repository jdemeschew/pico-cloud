package de.tinysite.pico.cloud.services.impl;

import de.tinysite.pico.cloud.services.PicoMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
public class PicoMailServiceImpl implements PicoMailService {
    Logger logger = LoggerFactory.getLogger(PicoMailServiceImpl.class);
    public String getMailHost() {
        return mailHost;

    }
    @Autowired
    JavaMailSender mailSender;

    public void setMailHost(String mailHost) {
        this.mailHost = mailHost;
    }

    public Integer getMailPort() {
        return mailPort;
    }

    public void setMailPort(Integer mailPort) {
        this.mailPort = mailPort;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
/*
Mail server address
 */
    private String mailHost;
    /*
    Mail server port
     */
    private Integer mailPort;
    /*
    User name for the authentication on the mail server
     */
    private String username;
    private String password;
    @Override
    public void send(String emailAddress, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("flufl@tinysite.de");
        message.setTo(emailAddress);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
        logger.info("Sent mail to {}",emailAddress);

    }
}

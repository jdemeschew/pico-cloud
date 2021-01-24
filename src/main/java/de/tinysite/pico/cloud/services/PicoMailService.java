package de.tinysite.pico.cloud.services;

import org.springframework.stereotype.Service;

/*Provides functionality for preparing and sending emails

 */
@Service
public interface PicoMailService {
/*
Sends email using supplied data
 */
    void send(String emailAddress, String subject,String content);
}

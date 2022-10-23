package com.bridgelabz.addressbookapp.configuration;

import com.bridgelabz.addressbookapp.utility.MailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public MailSender emailSenderService()
    {
        return new MailSender();
    }
}

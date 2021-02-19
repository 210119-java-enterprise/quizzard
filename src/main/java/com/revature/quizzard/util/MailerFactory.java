package com.revature.quizzard.util;

import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.mailer.MailerBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MailerFactory {

    private static final MailerFactory MAILER_FACTORY = new MailerFactory();

    private MailerFactory() {
        super();
    }

    public static MailerFactory getInstance() {
        return MAILER_FACTORY;
    }

    public Mailer buildMailer() {

        return MailerBuilder
                .withSMTPServer(
                        ApplicationProperties.APP_SMTP_HOST,
                        ApplicationProperties.APP_SMTP_PORT,
                        ApplicationProperties.APP_SMTP_EMAIL,
                        ApplicationProperties.APP_SMTP_EMAIL_PW)
                .withTransportStrategy(ApplicationProperties.APP_SMTP_TRANSPORT_STRATEGY)
                .withTransportModeLoggingOnly(false)
                .buildMailer();

    }

}

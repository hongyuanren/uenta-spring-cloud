package com.uenta.cloud.notification.service;

import javax.mail.MessagingException;

import com.uenta.cloud.notification.domain.NotificationType;
import com.uenta.cloud.notification.domain.Recipient;

import java.io.IOException;

public interface EmailService {

	void send(NotificationType type, Recipient recipient, String attachment) throws MessagingException, IOException;

}

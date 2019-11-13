package com.aayyoub.message.service.message.impl;

import com.aayyoub.message.exception.MessageFailedException;
import com.aayyoub.message.service.message.MessageSender;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwilioMessageSender implements MessageSender {
    private String accountSID;
    private String authToken;
    private String sender;

    public TwilioMessageSender(@Value("${twilio.accountSID}") String accountSID,
                               @Value("${twilio.authToken}") String authToken,
                               @Value("${twilio.sender}") String sender) {
        this.accountSID = accountSID;
        this.authToken = authToken;
        this.sender = sender;
    }

    public Boolean sendMessage(String recipient, String body) throws MessageFailedException {
        try {
            Twilio.init(accountSID, authToken);

            Message.creator(
                    new PhoneNumber("+".concat(recipient)),
                    new PhoneNumber(sender), body)
                    .create();
        } catch (Exception e) {
            throw new MessageFailedException("Failed to send SMS: " + e.getMessage());
        }

        return true;
    }
}
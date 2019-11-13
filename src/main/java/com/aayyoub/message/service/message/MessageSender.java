package com.aayyoub.message.service.message;

import com.aayyoub.message.exception.MessageFailedException;

public interface MessageSender {
    Boolean sendMessage(String recipient, String body) throws MessageFailedException;
}
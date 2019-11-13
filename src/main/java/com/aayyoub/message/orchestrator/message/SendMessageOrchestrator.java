package com.aayyoub.message.orchestrator.message;

import com.aayyoub.message.context.message.SendMessageContext;
import com.aayyoub.message.exception.MessageFailedException;
import com.aayyoub.message.service.message.MessageSender;
import org.springframework.stereotype.Component;

@Component
public class SendMessageOrchestrator {
    private final MessageSender messageSender;

    public SendMessageOrchestrator(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public Boolean orchestrate(SendMessageContext sendMessageContext) throws MessageFailedException {
        return messageSender.sendMessage(sendMessageContext.getRecipient(), sendMessageContext.getBody());
    }
}

package com.aayyoub.message.controller;

import com.aayyoub.message.context.message.SendMessageContext;
import com.aayyoub.message.exception.MessageFailedException;
import com.aayyoub.message.orchestrator.message.SendMessageOrchestrator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MessageController {
    private final SendMessageOrchestrator sendMessageOrchestrator;

    public MessageController(SendMessageOrchestrator sendMessageOrchestrator) {
        this.sendMessageOrchestrator = sendMessageOrchestrator;
    }

    @GetMapping("sendMessage")
    public Boolean sendMessage(SendMessageContext sendMessageContext) throws MessageFailedException {
        return sendMessageOrchestrator.orchestrate(sendMessageContext);
    }
}

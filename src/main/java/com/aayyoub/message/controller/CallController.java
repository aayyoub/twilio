package com.aayyoub.message.controller;

import com.aayyoub.message.context.call.MakeCallContext;
import com.aayyoub.message.exception.CallFailedException;
import com.aayyoub.message.orchestrator.call.PhoneCallOrchestrator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CallController {
    private final PhoneCallOrchestrator phoneCallOrchestrator;

    public CallController(PhoneCallOrchestrator phoneCallOrchestrator) {
        this.phoneCallOrchestrator = phoneCallOrchestrator;
    }

    @GetMapping("makeCall")
    public Boolean sendMessage(MakeCallContext makeCallContext) throws CallFailedException {
        return phoneCallOrchestrator.orchestrate(makeCallContext);
    }
}

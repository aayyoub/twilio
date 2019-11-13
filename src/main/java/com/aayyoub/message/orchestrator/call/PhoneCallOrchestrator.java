package com.aayyoub.message.orchestrator.call;

import com.aayyoub.message.context.call.MakeCallContext;
import com.aayyoub.message.exception.CallFailedException;
import com.aayyoub.message.service.call.PhoneCaller;
import org.springframework.stereotype.Component;

@Component
public class PhoneCallOrchestrator {
    private final PhoneCaller phoneCaller;

    public PhoneCallOrchestrator(PhoneCaller phoneCaller) {
        this.phoneCaller = phoneCaller;
    }

    public Boolean orchestrate(MakeCallContext makeCallContext) throws CallFailedException {
        return phoneCaller.makeCall(makeCallContext.getRecipient(), makeCallContext.getBody());
    }
}

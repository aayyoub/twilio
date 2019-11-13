package com.aayyoub.message.service.call.impl;

import com.aayyoub.message.exception.CallFailedException;
import com.aayyoub.message.service.call.PhoneCaller;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class TwilioPhoneCaller implements PhoneCaller {
    private String accountSID;
    private String authToken;
    private String caller;

    public TwilioPhoneCaller(@Value("${twilio.accountSID}") String accountSID,
                             @Value("${twilio.authToken}") String authToken, @Value("${twilio.sender}") String caller) {
        this.accountSID = accountSID;
        this.authToken = authToken;
        this.caller = caller;
    }

    public Boolean makeCall(String recipient, String body) throws CallFailedException {
        try {
            Twilio.init(accountSID, authToken);

            Call.creator(
                    new PhoneNumber("+".concat(recipient)),
                    new PhoneNumber(caller),
                    URI.create("http://demo.twilio.com/docs/voice.xml"))
                    .create();
        } catch (Exception e) {
            throw new CallFailedException("Failed to make call: " + e.getMessage());
        }

        return true;
    }
}
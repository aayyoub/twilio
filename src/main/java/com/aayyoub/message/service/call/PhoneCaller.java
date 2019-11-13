package com.aayyoub.message.service.call;

import com.aayyoub.message.exception.CallFailedException;

public interface PhoneCaller {
    Boolean makeCall(String recipient, String body) throws CallFailedException;
}
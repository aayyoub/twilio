package com.aayyoub.message.context.message;

public class SendMessageContext {
    private String recipient;
    private String body;

    public SendMessageContext() {
    }

    public SendMessageContext(String recipient, String body) {
        this.recipient = recipient;
        this.body = body;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

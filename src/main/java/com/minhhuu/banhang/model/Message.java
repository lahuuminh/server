package com.minhhuu.banhang.model;

public class Message {
    private String message;

    public String getMessage() {
        return message;
    }

    public Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

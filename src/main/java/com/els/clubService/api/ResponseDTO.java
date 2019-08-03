package com.els.clubService.api;

public class ResponseDTO {

    private String message;

    ResponseDTO(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

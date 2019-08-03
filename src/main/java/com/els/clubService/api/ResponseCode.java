package com.els.clubService.api;

public enum ResponseCode {

    SUCCESS("SUCCESS"),
    USER_NOT_FOUND("USER_NOT_FOUND");

    private String response;

    ResponseCode(final String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

}

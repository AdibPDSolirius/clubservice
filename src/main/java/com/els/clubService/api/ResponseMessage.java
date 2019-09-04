package com.els.clubService.api;

public enum ResponseMessage {

    CLUB_COULD_NOT_BE_CREATED("Club could not be created!"),
    SUCCESS("Success!"),
    USER_COULD_NOT_BE_ADDED_TO_CLUB("User could not be added to book club");

    private String response;

    ResponseMessage(final String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }
}

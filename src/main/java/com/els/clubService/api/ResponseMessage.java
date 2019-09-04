package com.els.clubService.api;

public enum ResponseMessage {

    CLUB_NOT_FOUND("Club could not be found!"),
    CLUB_COULD_NOT_BE_CREATED("Club could not be created!"),
    SUCCESS("Success!");

    private String response;

    ResponseMessage(final String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

}

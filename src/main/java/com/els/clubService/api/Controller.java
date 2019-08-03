package com.els.clubService.api;

import com.els.clubService.service.ClubService;
import com.google.gson.Gson;
import com.google.inject.Inject;
import spark.Request;
import spark.Response;

class Controller {

    private static final int SUCCESS_STATUS = 200;
    private static final int USER_NOT_FOUND_STATUS = 404;

    @Inject
    private Gson gson;

    @Inject
    private ClubService clubService;

    String createClub(final Request request, final Response response) {
        ClubDTO clubDTO = gson.fromJson(request.body(), ClubDTO.class);
        ResponseCode responseCode = clubService.createClub(clubDTO);
        setStatus(response, responseCode);
        response.header("Content-Type", "application/json");
        return gson.toJson(new ResponseDTO(responseCode.getResponse()));
    }

    void setStatus(final Response response, final ResponseCode responseCode) {
        switch(responseCode) {
            case SUCCESS: {
                response.status(SUCCESS_STATUS);
                break;
            }
            case USER_NOT_FOUND: {
                response.status(USER_NOT_FOUND_STATUS);
                break;
            }

        }
    }
}

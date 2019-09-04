package com.els.clubService.api;

import com.els.clubService.service.ClubService;
import com.google.gson.Gson;
import com.google.inject.Inject;

import org.eclipse.jetty.http.HttpStatus;

import spark.Request;
import spark.Response;

class Controller {

    private static final int SUCCESS_STATUS = HttpStatus.OK_200;
    private static final int NOT_FOUND_STATUS = HttpStatus.NOT_FOUND_404;
    private static final int CONFLICT_STATUS = HttpStatus.CONFLICT_409;

    private Gson gson = new Gson();

    @Inject
    private ClubService clubService;

    String createClub(final Request request, final Response response) {
        CreateClubDTO clubDTO = gson.fromJson(request.body(), CreateClubDTO.class);
        System.out.println("SYM");
        System.out.println(clubDTO);
        ResponseMessage responseCode = clubService.createClub(clubDTO);
        setStatus(response, responseCode);
        response.header("Content-Type", "application/json");
        return gson.toJson(new ResponseDTO(responseCode.getResponse()));
    }

    String addUserToClub(final Request request, final Response response){
        AddUserToClubDTO addUserToClubDTO = gson.fromJson(request.body(), AddUserToClubDTO.class);
        // verify user
        ResponseMessage responseCode = clubService.addUserToClub(addUserToClubDTO);
        setStatus(response, responseCode);
        response.header("Content-Type", "application/json");
        return gson.toJson(new ResponseDTO(responseCode.getResponse()));
    }

    private void setStatus(final Response response, final ResponseMessage responseCode) {
        switch(responseCode) {
            case SUCCESS: {
                response.status(SUCCESS_STATUS);
                break;
            }
            case CLUB_NOT_FOUND: {
                response.status(NOT_FOUND_STATUS);
                break;
            }
            case CLUB_COULD_NOT_BE_CREATED: {
                response.status(CONFLICT_STATUS);
                break;
            }
        }
    }
}

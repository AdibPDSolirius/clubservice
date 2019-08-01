package com.els.clubService.api;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

class Controller {

    Gson gson = new Gson();

    Response createClub(final Request request, final Response response) {
        ClubDTO clubDTO = gson.fromJson(request.body(), ClubDTO.class);

        System.out.println(clubDTO.getName());
        System.out.println(clubDTO.getDescription());
        System.out.println(clubDTO.getOwner().getName());
        return response;
    }
}

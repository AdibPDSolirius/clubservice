package com.els.clubService.api;

import static spark.Spark.post;

public class Router {

    private Controller controller = new Controller();

    public void handleRequests() {
        post("/club", controller::createClub);
    }
}

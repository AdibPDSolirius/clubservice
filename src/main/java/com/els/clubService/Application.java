package com.els.clubService;

import static spark.Spark.port;

import com.els.clubService.api.Router;

public class Application {

    public static void main(String[] args) {
        port(9999);
        new Router().handleRequests();
    }
}

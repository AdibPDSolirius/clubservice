package com.els.clubService;

import static spark.Spark.port;

import com.els.clubService.api.Router;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Application {

    public static void main(String[] args) {
        port(getPort());

        final Injector injector = Guice.createInjector();
        final Router router = injector.getInstance(Router.class);
        router.handleRequests();
    }

    private static Integer getPort(){
        return Integer.parseInt(System.getenv("PORT"));
    }
}

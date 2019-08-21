package com.els.clubService;

import static spark.Spark.port;

import com.els.clubService.api.Router;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.els.clubService.HibernateUtil;

public class Application {

    public static void main(String[] args) {
        port(getPort());

        final Injector injector = Guice.createInjector();
        final Router router = injector.getInstance(Router.class);
        router.handleRequests();
        HibernateUtil.getSessionFactory();
    }

    private static Integer getPort(){
        return Integer.parseInt(System.getenv("PORT"));
    }
}

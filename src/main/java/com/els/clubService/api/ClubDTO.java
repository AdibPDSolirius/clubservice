package com.els.clubService.api;

import java.util.UUID;

public class ClubDTO {

    private String name;
    private String description;
    private UUID owner;


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getOwner() {
        return owner;
    }
}

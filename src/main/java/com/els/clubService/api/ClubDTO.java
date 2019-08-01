package com.els.clubService.api;

class ClubDTO {

    private String name;
    private String description;
    private UserDTO userDTO;


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UserDTO getOwner() {
        return userDTO;
    }
}

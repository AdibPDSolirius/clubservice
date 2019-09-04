package com.els.clubService.api;

import java.util.UUID;

public class AddUserToClubDTO {
    private UUID userId;
    private UUID clubId;

    public UUID getUserId() {
        return userId;
    }

    public UUID getClubId() {
        return clubId;
    }
}
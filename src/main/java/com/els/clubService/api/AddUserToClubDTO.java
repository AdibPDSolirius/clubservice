package com.els.clubService.api;

import java.util.UUID;

public class AddUserToClubDTO {
    private String userId;
    private String clubId;

    public UUID getUserId() {
        return UUID.fromString(userId);
    }

    public UUID getClubId() {
        return UUID.fromString(clubId);
    }
}
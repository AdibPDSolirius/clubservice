package com.els.clubService.service;

import com.els.clubService.api.CreateClubDTO;
import com.els.clubService.api.AddUserToClubDTO;

import com.els.clubService.api.ResponseMessage;
import com.els.clubService.model.BookClub;
import com.els.clubService.model.BookClubRepository;
import com.google.inject.Inject;

public class ClubService {

    @Inject
    BookClubRepository bookClubRepository;

    public ResponseMessage createClub(final CreateClubDTO clubDTO) {
        boolean success = bookClubRepository.saveBookClub(convertToBookClub(clubDTO));
        return success ? ResponseMessage.SUCCESS : ResponseMessage.CLUB_COULD_NOT_BE_CREATED;
    }

    private BookClub convertToBookClub(CreateClubDTO clubDTO) {
        BookClub bookClub = new BookClub();
        bookClub.setName(clubDTO.getName());
        bookClub.setDescription(clubDTO.getDescription());
        bookClub.setOwner(clubDTO.getOwner().toString());

        return bookClub;
    }

    public ResponseMessage addUserToClub(final AddUserToClubDTO addUserToClubDTO) {
        boolean success = bookClubRepository.addUserToClub(addUserToClubDTO.getUserId(), addUserToClubDTO.getClubId());
        return success ? ResponseMessage.SUCCESS : ResponseMessage.USER_COULD_NOT_BE_ADDED_TO_CLUB;
    }
}

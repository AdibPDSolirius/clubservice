package com.els.clubService.service;

import com.els.clubService.api.CreateClubDTO;
import com.els.clubService.api.AddUserToClubDTO;

import com.els.clubService.api.ResponseCode;
import com.els.clubService.model.BookClub;
import com.els.clubService.model.BookClubRepository;
import com.google.inject.Inject;

public class ClubService {

    @Inject
    BookClubRepository bookClubRepository;

    public ResponseCode createClub(final CreateClubDTO clubDTO) {
        bookClubRepository.saveBookClub(convertToBookClub(clubDTO));
        return ResponseCode.SUCCESS;
    }

    private BookClub convertToBookClub(CreateClubDTO clubDTO) {
        BookClub bookClub = new BookClub();
        bookClub.setName(clubDTO.getName());
        bookClub.setDescription(clubDTO.getDescription());
        bookClub.setOwner(clubDTO.getOwner().toString());

        return bookClub;
    }

    public ResponseCode addUserToClub(final AddUserToClubDTO addUserToClubDTO) {
        bookClubRepository.addUserToClub(addUserToClubDTO.getUserId(), addUserToClubDTO.getClubId());
        return ResponseCode.SUCCESS;
    }


}

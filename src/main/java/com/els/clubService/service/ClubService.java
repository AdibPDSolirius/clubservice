package com.els.clubService.service;

import com.els.clubService.api.ClubDTO;
import com.els.clubService.api.ResponseCode;
import com.els.clubService.model.BookClub;
import com.els.clubService.model.BookClubRepository;
import com.google.inject.Inject;

public class ClubService {

    @Inject
    BookClubRepository bookClubRepository;
    public ResponseCode createClub(final ClubDTO clubDTO) {
        bookClubRepository.saveBookClub(convertToBookClub(clubDTO));
        return ResponseCode.SUCCESS;
    }

    public BookClub convertToBookClub(ClubDTO clubDTO) {
        BookClub bookClub = new BookClub();
        bookClub.setName(clubDTO.getName());
        bookClub.setDescription(clubDTO.getDescription());
        bookClub.setOwner(clubDTO.getOwner());

        return bookClub;
    }


}

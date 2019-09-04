package com.els.clubService.service;

import com.els.clubService.api.AddUserToClubDTO;
import com.els.clubService.api.CreateClubDTO;
import com.els.clubService.api.ResponseMessage;
import com.els.clubService.model.BookClub;
import com.els.clubService.model.BookClubRepository;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClubServiceTest {

    @Spy
    CreateClubDTO createClubDTO;

    @Spy
    AddUserToClubDTO addUserToClubDTO;

    @Mock
    BookClubRepository bookClubRepository;

    @InjectMocks
    ClubService clubService;

    @Test
    public void shouldReturnSuccessWhenCreateClubSuccessful(){
        when(createClubDTO.getName()).thenReturn("Mock name");
        when(createClubDTO.getOwner()).thenReturn(UUID.randomUUID());
        when(createClubDTO.getDescription()).thenReturn("Mock description");

        when(bookClubRepository.saveBookClub(any(BookClub.class))).thenReturn(true);

        ResponseMessage responseMessage = clubService.createClub(createClubDTO);

        assertEquals(ResponseMessage.SUCCESS, responseMessage);
    }

    @Test
    public void shouldReturnClubCouldNotBeCreatedWhenCreateClubFails(){
        when(createClubDTO.getName()).thenReturn("Mock name");
        when(createClubDTO.getOwner()).thenReturn(UUID.randomUUID());
        when(createClubDTO.getDescription()).thenReturn("Mock description");

        when(bookClubRepository.saveBookClub(any(BookClub.class))).thenReturn(false);

        ResponseMessage responseMessage = clubService.createClub(createClubDTO);

        assertEquals(ResponseMessage.CLUB_COULD_NOT_BE_CREATED, responseMessage);
    }

    @Test
    public void shouldReturnSuccessWhenAddUserToClubSuccessful(){
        when(addUserToClubDTO.getClubId()).thenReturn(UUID.randomUUID());
        when(addUserToClubDTO.getUserId()).thenReturn(UUID.randomUUID());

        when(bookClubRepository.addUserToClub(any(UUID.class), any(UUID.class))).thenReturn(true);

        ResponseMessage responseMessage = clubService.addUserToClub(addUserToClubDTO);

        assertEquals(ResponseMessage.SUCCESS, responseMessage);
    }

    @Test
    public void shouldReturnConflicWhenAddUserToClubFails(){
        when(addUserToClubDTO.getClubId()).thenReturn(UUID.randomUUID());
        when(addUserToClubDTO.getUserId()).thenReturn(UUID.randomUUID());

        when(bookClubRepository.addUserToClub(any(UUID.class), any(UUID.class))).thenReturn(false);

        ResponseMessage responseMessage = clubService.addUserToClub(addUserToClubDTO);

        assertEquals(ResponseMessage.USER_COULD_NOT_BE_ADDED_TO_CLUB, responseMessage);
    }
}

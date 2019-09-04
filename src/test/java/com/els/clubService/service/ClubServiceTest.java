package com.els.clubService.service;

import com.els.clubService.api.CreateClubDTO;
import com.els.clubService.api.ResponseMessage;
import com.els.clubService.model.BookClub;
import com.els.clubService.model.BookClubRepository;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
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

    @Mock
    BookClubRepository bookClubRepository;

    @InjectMocks
    ClubService clubService;

    @Test
    public void shouldReturnSuccessWhenCreateClub(){
        when(createClubDTO.getName()).thenReturn("Mock Name");
        when(createClubDTO.getOwner()).thenReturn(UUID.randomUUID());
        when(createClubDTO.getDescription()).thenReturn("Mock Description");

        when(bookClubRepository.saveBookClub(any(BookClub.class))).thenReturn(true);

        ResponseMessage responseMessage = clubService.createClub(createClubDTO);

        assertEquals(ResponseMessage.SUCCESS, responseMessage);
    }

}

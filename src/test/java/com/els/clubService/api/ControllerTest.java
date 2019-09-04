package com.els.clubService.api;

import spark.Request;
import spark.Response;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import com.google.gson.Gson;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;


import com.els.clubService.service.ClubService;
import com.els.clubService.api.ResponseMessage;
import com.els.clubService.api.CreateClubDTO;

import org.junit.Test;
import static org.junit.Assert.*;

import org.eclipse.jetty.http.HttpStatus;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @Captor
    ArgumentCaptor<Integer> httpStatusCaptor;

    @Mock
    Request request;

    @Mock
    Response response;

    @Mock
    ClubService clubService;
    
    @InjectMocks
    Controller controller;

    @Test
    public void shouldSetStatusToHTTPOKWhenSuccessful(){
        when(request.body()).thenReturn(new Gson().toJson(new CreateClubDTO()));
        when(clubService.createClub(any(CreateClubDTO.class))).thenReturn(ResponseMessage.SUCCESS);
        
        controller.createClub(request, response);
        
        verify(response).status(httpStatusCaptor.capture());
        int httpStatus = httpStatusCaptor.getValue();
        assertEquals(HttpStatus.OK_200, httpStatus);
    }

    @Test
    public void shouldSetStatusToHTTPConflictWhenClubCouldNotBeCreated(){
        when(request.body()).thenReturn(new Gson().toJson(new CreateClubDTO()));
        when(clubService.createClub(any(CreateClubDTO.class))).thenReturn(ResponseMessage.CLUB_COULD_NOT_BE_CREATED);
        
        controller.createClub(request, response);
        
        verify(response).status(httpStatusCaptor.capture());
        int httpStatus = httpStatusCaptor.getValue();
        assertEquals(HttpStatus.CONFLICT_409, httpStatus);
    }
    
}
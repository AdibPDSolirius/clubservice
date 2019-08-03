package com.els.clubService.model;

import java.util.List;
import java.util.UUID;

public class BookClub {

    String id;

    String name;

    String description;

    List<UUID> previouslyReadBooks;

    UUID currentBook;

    UUID owner;

    List<UUID> previousMeetings;

    UUID nextMeeting;

    List<UUID> members;

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public List<UUID> getPreviouslyReadBooks() {
        return previouslyReadBooks;
    }

    public void setPreviouslyReadBooks(final List<UUID> previouslyReadBooks) {
        this.previouslyReadBooks = previouslyReadBooks;
    }

    public UUID getCurrentBook() {
        return currentBook;
    }

    public void setCurrentBook(final UUID currentBook) {
        this.currentBook = currentBook;
    }

    public List<UUID> getPreviousMeetings() {
        return previousMeetings;
    }

    public void setPreviousMeetings(final List<UUID> previousMeetings) {
        this.previousMeetings = previousMeetings;
    }

    public UUID getNextMeeting() {
        return nextMeeting;
    }

    public void setNextMeeting(final UUID nextMeeting) {
        this.nextMeeting = nextMeeting;
    }

    public List<UUID> getMembers() {
        return members;
    }

    public void setMembers(final List<UUID> members) {
        this.members = members;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(final UUID owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}

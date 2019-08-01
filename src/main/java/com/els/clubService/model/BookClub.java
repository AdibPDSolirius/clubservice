package com.els.clubService.model;

import java.util.List;

public class BookClub {

    String id;

    String name;

    String description;

    List<Book> previouslyReadBooks;

    Book currentBook;

    User owner;

    List<Meeting> previousMeetings;

    Meeting nextMeeting;

    List<User> members;

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public List<Book> getPreviouslyReadBooks() {
        return previouslyReadBooks;
    }

    public void setPreviouslyReadBooks(final List<Book> previouslyReadBooks) {
        this.previouslyReadBooks = previouslyReadBooks;
    }

    public Book getCurrentBook() {
        return currentBook;
    }

    public void setCurrentBook(final Book currentBook) {
        this.currentBook = currentBook;
    }

    public List<Meeting> getPreviousMeetings() {
        return previousMeetings;
    }

    public void setPreviousMeetings(final List<Meeting> previousMeetings) {
        this.previousMeetings = previousMeetings;
    }

    public Meeting getNextMeeting() {
        return nextMeeting;
    }

    public void setNextMeeting(final Meeting nextMeeting) {
        this.nextMeeting = nextMeeting;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(final List<User> members) {
        this.members = members;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(final User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}

package com.els.clubService.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "book_club")
public class BookClub {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    String id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "previously_read_books")
    List<UUID> previouslyReadBooks;

    @Column(name = "current_book")
    UUID currentBook;

    @Column(name = "owner")
    UUID owner;

    @Column(name = "previous_meetings")
    List<UUID> previousMeetings;

    @Column(name = "next_meeting")
    UUID nextMeeting;

    @Column(name = "members")
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

package com.els.clubService.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.ElementCollection;


@Entity(name = "book_club")
@Table(name = "book_club")
public class BookClub {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
		name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    UUID id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    // @ElementCollection
    // @Column(name = "previously_read_books")
    // List<String> previouslyReadBooks;

    @Column(name = "current_book")
    String currentBook;

    @Column(name = "owner")
    String owner;

    // @ElementCollection
    // @Column(name = "previous_meetings")
    // List<String> previousMeetings;

    @Column(name = "next_meeting")
    String nextMeeting;

    @ElementCollection
    @Column(name = "members")
    Set<UUID> members;

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    // public List<String> getPreviouslyReadBooks() {
    //     return previouslyReadBooks;
    // }

    // public void setPreviouslyReadBooks(final List<String> previouslyReadBooks) {
    //     this.previouslyReadBooks = previouslyReadBooks;
    // }

    public String getCurrentBook() {
        return currentBook;
    }

    public void setCurrentBook(final String currentBook) {
        this.currentBook = currentBook;
    }

    // public List<String> getPreviousMeetings() {
    //     return previousMeetings;
    // }

    // public void setPreviousMeetings(final List<String> previousMeetings) {
    //     this.previousMeetings = previousMeetings;
    // }

    public String getNextMeeting() {
        return nextMeeting;
    }

    public void setNextMeeting(final String nextMeeting) {
        this.nextMeeting = nextMeeting;
    }

    public Set<UUID> getMembers() {
        return members;
    }

    public void setMembers(final Set<UUID> members) {
        this.members = members;
    }

    public void addMember(final UUID member){
        this.members.add(member);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(final String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }
}

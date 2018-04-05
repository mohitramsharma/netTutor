package com.netTutor.application.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "userEntity")
public class UserEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String username;
    private String password;
    private String description;
    private String age;
    private boolean isAuthd = false;

//    @OneToMany
//    private UserLoggedSession session;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToOne
    private Contact contact;
    @OneToMany
    private Set<Address> addresses;
    //@ManyToMany
  //  private Set<Session> sessions;
//    @OneToMany
//    private Set<Subscription> subscriptions;

//    public Set<Session> getSessions() {
//        return sessions;
//    }

//    public UserLoggedSession getSession() {
//        return session;
//    }
//
//    public void setSession(UserLoggedSession session) {
//        this.session = session;
//    }

//    public void setSessions(Set<Session> sessions) {
//        this.sessions = sessions;
//    }

    //
//    public Set<Subscription> getSubscriptions() {
//        return subscriptions;
//    }
//
//    public void setSubscriptions(Set<Subscription> subscriptions) {
//        this.subscriptions = subscriptions;
//    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
//
    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
//
//    public Set<Session> getSessions() {
//        return sessions;
//    }
//
//    public void setSessions(Set<Session> sessions) {
//        this.sessions = sessions;
//    }

    public boolean isAuthd() {
        return isAuthd;
    }

    public void setAuthd(boolean authd) {
        isAuthd = authd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

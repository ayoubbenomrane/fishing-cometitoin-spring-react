package com.medianet.fishingCompetiton.DTOs.user;

import com.medianet.fishingCompetiton.models.Role;

public class UpdateUserDTO {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private String profilePicture;
    private Role role;
    public UpdateUserDTO(String firstName, String lastName, String phoneNumber, String email, String password, String profilePicture,Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.profilePicture = profilePicture;
        this.role=role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

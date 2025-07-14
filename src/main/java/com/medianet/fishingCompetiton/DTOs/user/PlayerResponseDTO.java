package com.medianet.fishingCompetiton.DTOs.user;

public class PlayerResponseDTO {
    String firstName;
    String lastName;
    String profilePicture;

    public PlayerResponseDTO(String firstName, String lastName, String profilePicture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
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

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}

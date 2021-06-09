package com.myclub.services.member;

// serialization and deserialization
// @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
// @JsonNaming, @JsonProperty, @JsonAlias, @JsonIgnore, @JsonInclude 에 대해 알아보자
public class MemberModifyInfoRequest {
    
    private String previousId;
    private String newId;

    private String previousPassword;
    private String newPassword;

    private String previousName;
    private String newName;

    private String previousAddress;
    private String newAddress;

    private String previousEmail;
    private String newEmail;


    // getter, setter
    public String getPreviousId() {
        return previousId;
    }

    public void setPreviousId(String previousId) {
        this.previousId = previousId;
    }

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }

    public String getPreviousPassword() {
        return previousPassword;
    }

    public void setPreviousPassword(String previousPassword) {
        this.previousPassword = previousPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getPreviousName() {
        return previousName;
    }

    public void setPreviousName(String previousName) {
        this.previousName = previousName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getPreviousAddress() {
        return previousAddress;
    }

    public void setPreviousAddress(String previousAddress) {
        this.previousAddress = previousAddress;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
    }

    public String getPreviousEmail() {
        return previousEmail;
    }

    public void setPreviousEmail(String previousEmail) {
        this.previousEmail = previousEmail;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }


    @Override
    public String toString() {
        return "previousId ="+ previousId+ ", "+"newId = "+newId+", "+
            "previousPassword ="+ previousPassword+ ", "+"newPassword = "+newPassword+", "+
            "previousName ="+ previousName+ ", "+"newName = "+newName+", "+
            "previousAddress ="+ previousAddress+ ", "+"newAddress = "+newAddress+", "+
            "previousEmail ="+ previousEmail+ ", "+"newEmail = "+newEmail;
    }

}

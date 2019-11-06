package team.ustc.sensor.entity.user;

import javax.persistence.Entity;

@Entity
public class IndividualUser extends User {
    private int userPhoneNumber;  //用户电话号码
    private String userEmailAddress;  //用户电子邮件地址
    private String userIntroduction;  //用户简介

    public int getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(int userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }
}

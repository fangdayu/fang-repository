package team.ustc.sensor.entity.user;

import javax.persistence.Entity;

@Entity
public class CompanyUser extends User {
    private int userPhoneNumber;  //用户电话号码
    private String userEmailAddress;  //用户电子邮件地址
    private String userIntroduction;  //用户简介
}

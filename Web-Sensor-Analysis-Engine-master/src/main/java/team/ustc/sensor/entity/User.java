package team.ustc.sensor.entity;

import java.math.BigDecimal;

/**
 * 账号实体类
 *
 * @auther MrJoker
 */
public class User {
    // 用户名
    String username;
    // 密码
    String password;
    // 是否为公司
    boolean isCompany;
    // 公司名称（公司特有）
    String name = null;
    // 公司描述（公司特有）
    String description = null;
    // 余额
    BigDecimal balance;

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

    public boolean isCompany() {
        return isCompany;
    }

    public void setCompany(boolean company) {
        isCompany = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

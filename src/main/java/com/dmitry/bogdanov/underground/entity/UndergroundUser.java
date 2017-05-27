package com.dmitry.bogdanov.underground.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "underground_user")
public class UndergroundUser {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "USER_ID", unique = true, nullable = false)
    private long userId;

    @Column(name = "USER_NAME", nullable = false, length = 60)
    private String userLogin;

    @Column(name = "USER_PASSWORD", nullable = false, length = 60)
    private String userPassword;

    @Column(name = "USER_TYPE_ID", nullable = false)
    private long userTypeId;

    public UndergroundUser() {
        userId = 0;
        userTypeId = 0;
    }

    public UndergroundUser(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    public UndergroundUser(String userLogin, String userPassword, long userTypeId) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userTypeId = userTypeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(long userTypeId) {
        this.userTypeId = userTypeId;
    }
}

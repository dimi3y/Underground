package com.dmitry.bogdanov.underground.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "user_type")
public class UserType {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "USER_TYPE_ID", unique = true, nullable = false)
    private long userTypeId;

    @Column(name = "USER_TYPE_NAME", nullable = false, length = 60)
    private String userTypeName;

    public UserType() {
    }

    public UserType(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(long userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }
}

package com.michael.group;

import com.michael.pojo.User;
import com.michael.pojo.UserDesc;

public class UserGroup {
    private User user;
    private UserDesc userDesc;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDesc getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(UserDesc userDesc) {
        this.userDesc = userDesc;
    }
}

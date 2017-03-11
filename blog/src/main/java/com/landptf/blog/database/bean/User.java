package com.landptf.blog.database.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by liyulong on 2017/3/11.
 */
@Entity
public class User {
    @Id
    private String uerId;
    @NotNull
    private String userName;
    private int password;
    @Generated(hash = 1346109477)
    public User(String uerId, @NotNull String userName, int password) {
        this.uerId = uerId;
        this.userName = userName;
        this.password = password;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public String getUerId() {
        return this.uerId;
    }
    public void setUerId(String uerId) {
        this.uerId = uerId;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getPassword() {
        return this.password;
    }
    public void setPassword(int password) {
        this.password = password;
    }
}

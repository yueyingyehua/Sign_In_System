package cn.tsuki.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tsuki on 2017/4/14.
 */
public class Account {
    private int id; //序号
    private String username; //用户名
    private String password; //密码
    private Set<CheckIn> checkIns = new HashSet<CheckIn>();

    public Account() {

    }

    public Account(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Set<CheckIn> getCheckIns() {
        return checkIns;
    }

    public void setCheckIns(Set<CheckIn> checkIns) {
        this.checkIns = checkIns;
    }
}

package cn.tsuki.domain;

/**
 * Created by tsuki on 2017/4/14.
 */
public class CheckIn {
    private int id; //序号
    private String checkin_time;  //签到时间
    private Account account; //签到账号

    public CheckIn() {
    }

    public CheckIn(int id, String checkin_time, Account account) {
        this.id = id;
        this.checkin_time = checkin_time;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCheckin_time() {
        return checkin_time;
    }

    public void setCheckin_time(String checkin_time) {
        this.checkin_time = checkin_time;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

package cn.tsuki.service;

import cn.tsuki.domain.CheckIn;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tsuki on 2017/4/14.
 */
@Transactional
public interface SignInService {
    //验证用户登入是否成功
    boolean accountLogin(String username, String password);
    //新用户注册
    int registAccount(String username, String password);
    //签到
    int checkIn(String username, String date);
    //获取用户签到信息
    List<CheckIn> getCheckInsByAccount(String username);

    //验证是否签到
    boolean IshasCheckIn(String username, String date);

    //验证用户名是否可用
    boolean validataName(String username);

}

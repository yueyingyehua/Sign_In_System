package cn.tsuki.service.impl;

import cn.tsuki.dao.AccountDao;
import cn.tsuki.dao.CheckInDao;
import cn.tsuki.domain.Account;
import cn.tsuki.domain.CheckIn;
import cn.tsuki.exception.SignInException;
import cn.tsuki.service.SignInService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tsuki on 2017/4/14.
 */
@Transactional
public class SignInServiceImpl implements SignInService{

    private AccountDao accountDao = null;
    private CheckInDao checkInDao = null;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setCheckInDao(CheckInDao checkInDao) {
        this.checkInDao = checkInDao;
    }

    public boolean accountLogin(String username, String password) {
        try {
            Account account = accountDao.findByName(username);
            if (account != null && account.getPassword().equals(password)) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new SignInException("处理用户登录出现异常！");
        }

    }

    public int registAccount(String username, String password) {
        try{
            Account account = new Account();
            account.setUsername(username);
            account.setPassword(password);
            accountDao.save(account);
            return account.getId();
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new SignInException("新用户注册出现异常！");
        }
    }

    public int checkIn(String username, String date) {
        try{
            CheckIn checkIn = new CheckIn();
            checkIn.setCheckin_time(date);
            checkIn.setAccount(accountDao.findByName(username));
            checkInDao.save(checkIn);
            return checkIn.getId();
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new SignInException("签到过程出现异常！");
        }

    }

    public List<CheckIn> getCheckInsByAccount(String username) {
        try{
            List<CheckIn> checkInList = checkInDao.findByAccount(accountDao.findByName(username));
            return checkInList;
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new SignInException("查询签到列表的过程出现异常！");
        }
    }

    public boolean IshasCheckIn(String username, String date) {
        try{
            if (checkInDao.findByAccount(accountDao.findByName(username)).get(0).getCheckin_time().equals(date)) {
                return true;
            }
            return false;
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new SignInException("验证是否签到过程出现异常！");
        }

    }

    public boolean validataName(String username) {
       try{
           Account account = accountDao.findByName(username);
           if (account != null) {
               return false;
           }
           return true;
       }catch (Exception ex) {
           ex.printStackTrace();
           throw new SignInException("验证用户名是否存在的过程中出现异常！");
       }
    }
}

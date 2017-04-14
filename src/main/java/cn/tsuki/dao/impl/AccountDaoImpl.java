package cn.tsuki.dao.impl;

import cn.tsuki.common.dao.impl.BaseDaoImpl;
import cn.tsuki.dao.AccountDao;
import cn.tsuki.domain.Account;

import java.util.List;

/**
 * Created by tsuki on 2017/4/14.
 */
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao {

    public Account findByName(String name) {
        List<Account> accounts = find("select a from Account a where a.username = ?0", name);
        if (accounts != null && accounts.size() == 1) {
            return accounts.get(0);
        }
        return null;
    }
}

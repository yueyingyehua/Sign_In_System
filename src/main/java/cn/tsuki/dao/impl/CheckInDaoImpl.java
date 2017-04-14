package cn.tsuki.dao.impl;

import cn.tsuki.common.dao.impl.BaseDaoImpl;
import cn.tsuki.dao.CheckInDao;
import cn.tsuki.domain.Account;
import cn.tsuki.domain.CheckIn;

import java.util.List;

/**
 * Created by tsuki on 2017/4/14.
 */
public class CheckInDaoImpl extends BaseDaoImpl<CheckIn> implements CheckInDao {

    public List<CheckIn> findByAccount(Account account) {
        List<CheckIn> checkIns = find("select c from CheckIn c where c.account = ?0", account);
        return checkIns;
    }
}

package cn.tsuki.dao;

import cn.tsuki.common.dao.BaseDao;
import cn.tsuki.domain.Account;
import cn.tsuki.domain.CheckIn;

import java.util.List;

/**
 * Created by tsuki on 2017/4/14.
 */
public interface CheckInDao extends BaseDao<CheckIn> {
    List<CheckIn> findByAccount(Account account);
}

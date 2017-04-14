package cn.tsuki.dao;

import cn.tsuki.common.dao.BaseDao;
import cn.tsuki.domain.Account;

/**
 * Created by tsuki on 2017/4/14.
 */
public interface AccountDao extends BaseDao<Account>{
    Account findByName(String name);

}

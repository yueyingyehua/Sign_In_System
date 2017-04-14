package cn.tsuki.common.dao.impl;

import cn.tsuki.common.dao.BaseDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tsuki on 2017/4/14.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }
    @SuppressWarnings("unchecked")
    public T get(Class<T> entityClazz, Serializable id) {
        return (T) getSessionFactory().getCurrentSession().get(entityClazz, id);
    }

    public Serializable save(T entity) {
        return getSessionFactory().getCurrentSession().save(entity);
    }

    public void update(T entity) {
        getSessionFactory().getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(T entity) {
        getSessionFactory().getCurrentSession().delete(entity);
    }

    public void delete(Class<T> entityClazz, Serializable id) {
        delete(get(entityClazz,id));
    }

    public List<T> findAll(Class<T> entityClazz) {
        return find("select en from " + entityClazz.getSimpleName() + " en");
    }

    public long findCount(Class<T> entityClazz) {
        List l = find("select count(*) from "
                + entityClazz.getSimpleName());
        //查询得到的实体总数
        if (l != null && l.size() == 1)
        {
            return (Long) l.get(0);
        }
        return 0;
    }

    protected List<T> find(String hql, Object... params) {
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        for (int i = 0, len = params.length; i < len; i++) {
            query.setParameter(i + "", params[i]);
        }
        return (List<T>) query.list();
    }
}

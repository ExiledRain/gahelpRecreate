package io.khasang.gahelp.dao.impl;

import io.khasang.gahelp.dao.HorseDao;
import io.khasang.gahelp.entity.Horse;

import java.util.List;

public class HorseDaoImpl extends BasicDaoImpl<Horse> implements HorseDao {
    public HorseDaoImpl(Class<Horse> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Horse> getByName(String name) {
        List<Horse> list = getSession().createQuery("from Horse where name = ?1")
                .setParameter(1,name).list();
        return list;
    }
}

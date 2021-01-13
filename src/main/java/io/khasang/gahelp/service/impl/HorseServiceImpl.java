package io.khasang.gahelp.service.impl;

import io.khasang.gahelp.dao.HorseDao;
import io.khasang.gahelp.entity.Horse;
import io.khasang.gahelp.service.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("horseService")
public class HorseServiceImpl implements HorseService {
    private HorseDao horseDao;

    @Override
    public Horse add(Horse horse) {
        return horseDao.add(horse);
    }

    @Override
    public Horse getById(long id) {
        return horseDao.getById(id);
    }

    @Override
    public List<Horse> getAll() {
        return horseDao.getAll();
    }

    @Override
    public Horse delete(long id) {
        return horseDao.delete(getById(id));
    }

    @Override
    public Horse update(Horse horse) {
        return horseDao.update(horse);
    }

    @Autowired
    public void setHorseDao(HorseDao horseDao) {
        this.horseDao = horseDao;
    }
}

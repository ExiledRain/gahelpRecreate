package io.khasang.gahelp.dao;

import io.khasang.gahelp.entity.Horse;

import java.util.List;

public interface HorseDao extends BasicDao<Horse>{
    List<Horse> getByName(String name);
}

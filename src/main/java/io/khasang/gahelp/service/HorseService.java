package io.khasang.gahelp.service;

import io.khasang.gahelp.entity.Horse;

import java.util.List;

public interface HorseService {
    /**
     * service for adding horse
     *
     * @param horse for adding
     * @return  added horse
     * */
    Horse add(Horse horse);

    /**
     * service for geting horse by Id
     * @param id - horse id
     * @return specific horse by id
     * */
    Horse getById(long id);

    /**
     * service to get all horses
     * @return horses list
     * */
    List<Horse> getAll();

    /**
     * service to delete horse
     * @param id - id horse to delete
     * @return horse deleted
     * */
    Horse delete(long id);

    /**
     * service to update horse
     * @return updated horse
     * @param horse - specific horse for the update
     * */
    Horse update(Horse horse);
}

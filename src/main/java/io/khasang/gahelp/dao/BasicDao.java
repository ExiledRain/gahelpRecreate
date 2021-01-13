package io.khasang.gahelp.dao;

import io.khasang.gahelp.entity.Horse;

import java.util.List;

public interface BasicDao<T> {
    /**
     * service for adding entity
     *
     * @param entity for adding
     * @return added entity
     */
    T add(T entity);

    /**
     * service for getting entity by Id
     *
     * @param id - entity id
     * @return specific entity by id
     */
    T getById(long id);

    /**
     * service to get all entities
     *
     * @return entities list
     */
    List<T> getAll();
    /**
     * service to delete horse
     * @param entity - id entity to delete
     * @return entity deleted
     * */
    T delete(T entity);

    /**
     * service to update entity
     * @param entity - specific entity to be updated
     * @return T updated entity
     * */
    T update(T entity);
}

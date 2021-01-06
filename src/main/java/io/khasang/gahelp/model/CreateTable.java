package io.khasang.gahelp.model;

import java.util.List;

public interface CreateTable {
    /**
     * Method required for adding table to DB
     * return status with String
     * */
    String tableCreationStatus();

    /***
     * Method get count of cats in database
     */
    Integer check();

    /**
     * Add specific cat to the table
     * @param name - name of the inserted cat
     * @param color - color of the inserted cat
     * @return status of the operation
     */
    String addCat(String name, String color);

    /**
     * Get list of all cat names
     */
    String getCatNames();

    /**
     * Update color of specific cat
     */
      String updateCatColor(String name,String color);

    /**
     * Delete cat by name
     */
    String deleteCatByName(String name);
}

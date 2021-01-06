package io.khasang.gahelp.model.impl;

import io.khasang.gahelp.model.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service("createTable")
public class CreateTableImpl implements CreateTable {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CreateTableImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String tableCreationStatus() {
        try {


            jdbcTemplate.execute("DROP TABLE IF EXISTS dogs");
            jdbcTemplate.execute("create table dogs\n" +
                    "(\n" +
                    "\tid int not null,\n" +
                    "\tname varchar(255),\n" +
                    "\tdescription varchar(255)\n" +
                    ");\n" +
                    "\n" +
                    "create unique index dogs_id_uindex\n" +
                    "\ton dogs (id);\n" +
                    "\n" +
                    "alter table dogs\n" +
                    "\tadd constraint dogs_pk\n" +
                    "\t\tprimary key (id);\n" +
                    "\n");
        } catch (Exception e) {
            return "Table failed to create " + e.getMessage();
        }
        return "Table Created";
    }

    public Integer check() {
        int catCount = this.jdbcTemplate.queryForObject("select count(*) from cats", Integer.class);
        return catCount;
    }

    @Override
    public String addCat(String name, String color) {
        try {
            int random = new Random().nextInt(3) + 1;
            jdbcTemplate.update("insert into cats(id,name,description,color_id) values(?,?,?,?)", check() + 1, name, color, random);
        } catch (Exception e) {
            return "Failed to add to the table " + e.getMessage();
        }
        return "Added new cat";
    }


    @Override
    public String getCatNames() {
        String name = "";
        List<String> names = jdbcTemplate.query(
                "select name from cats",(resultSet, rowNum) -> {
                    return resultSet.getString("name");
                });
        for (String item : names) {
            name += item + ",";
        }
        return name;
    }

    @Override
    public String updateCatColor(String name, String color) {
        try {
        jdbcTemplate.update("update cats set description = ? where name = ?",color,name);
        } catch (Exception e) {
            return "Couldn't update the data " + e.getMessage();
        }
        return "Updated table for Cat: " + name + " new description is : " + color ;
    }

    @Override
    public String deleteCatByName(String name) {
        try {
            jdbcTemplate.update("delete from cats where name = ?",name);
        } catch (Exception e) {
            return "Deleting failed " + e.getMessage();
        }
        return "Super cat " + name + " was deleted.";
    }
}

package io.khasang.gahelp.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String model;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE")
    private LocalDate year;

    @ManyToMany(mappedBy = "carList",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Employee> employees = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }
}

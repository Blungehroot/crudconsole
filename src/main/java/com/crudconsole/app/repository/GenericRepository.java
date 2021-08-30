package com.crudconsole.app.repository;

import com.crudconsole.app.model.Label;

import java.util.List;

public interface GenericRepository<T, ID> {

    Label getById(ID id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(ID id);
}

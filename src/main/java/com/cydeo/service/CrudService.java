package com.cydeo.service;

import java.util.List;

public interface CrudService <T, ID> {

    T save(T t);
    List<T> FindAll();
    T findById(ID id);
    void deleteById(ID id);

}

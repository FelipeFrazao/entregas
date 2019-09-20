package com.entregas.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Collection;

public abstract class DefaultService {

    public DefaultService() {}

    private JpaRepository repository;

    public DefaultService(JpaRepository repository) {
        this.repository = repository;
    }

    public Collection getAllData() {

        Collection collection = new ArrayList();
        repository.findAll().forEach(collection::add);

        return collection;
    }

    public Object getById(Long id) {

        Object object = repository.findById(id).get();
        return object;
    }

    public boolean save(Object object, String service) {
        try {
            repository.save(object);
            return true;
        } catch (Exception ex) {
            System.out.printf("[%sSERVICE][SAVE%s] ERROR ON SAVE %s %s",service, service, service, ex.getMessage());
            return false;
        }
    }

    public boolean deleteById(Long id, String service) {

        try {
            repository.deleteById(id);
            return true;
        } catch (Exception ex) {
            System.out.printf("[%sSERVICE][SAVE%s] ERROR ON SAVE %s %s",service, service, service, ex.getMessage());
            return false;
        }
    }

}

package com.empik.empik_backend;

import com.empik.empik_backend.infrastructure.entity.AbstractEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryRepositoryImpl<T extends AbstractEntity, ID> implements ListCrudRepository<T, ID> {

    protected List<T> data = new ArrayList<>();

    @Override
    public <S extends T> S save(S entity) {
        if(entity.getId() == null) {
            entity.setId(Long.valueOf(data.size() + 1));
        }else{
            Optional<T> first = data.stream().filter(f -> f.getId().equals(entity.getId())).findFirst();
            first.ifPresent(t -> data.remove(t));
        }
        data.add(entity);
        return entity;
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Optional<T> findById(ID id) {
        return data.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean existsById(ID id) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<T> findAll() {
        return data;
    }

    @Override
    public List<T> findAllById(Iterable<ID> ids) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public long count() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteById(ID id) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void delete(T entity) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteAllById(Iterable<? extends ID> ids) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteAll() {
        throw new RuntimeException("Not implemented");
    }
}
package com.example.bankingsystem.repositories;

import com.example.bankingsystem.models.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericRepository<T extends BaseEntity> implements BaseRepository<T> {
    protected List<T> entities = new ArrayList<>();

    @Override
    public void add(T entity) {
        entities.add(entity);
    }

    @Override
    public Optional<T> getById(int id) {
        return entities.stream().filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public void update(T entity) {
        delete(entity.getId());
        entities.add(entity);
    }

    @Override
    public void delete(int id) {
        entities.removeIf(e -> e.getId() == id);
    }
}

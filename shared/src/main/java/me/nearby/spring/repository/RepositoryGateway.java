package me.nearby.spring.repository;


import org.springframework.data.domain.Slice;

import java.io.Serializable;
import java.util.List;

public interface RepositoryGateway<T extends Serializable, ID extends Serializable> {
    T getOne(ID id);

    List<T> findAll();


    List<T> saveAll(Iterable<T> objects);

    boolean deleteById(ID id);

    long countAll();

    T save(T object);
}

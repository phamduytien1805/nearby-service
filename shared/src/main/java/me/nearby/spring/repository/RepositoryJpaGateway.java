package me.nearby.spring.repository;

import java.io.Serializable;

public interface RepositoryJpaGateway<T extends Serializable, ID extends Serializable> {
    T saveAndFlush(T object);
}

package me.nearby.spring.shared.repository;

import java.io.Serializable;

public interface RepositoryJpaGateway<T extends Serializable, ID extends Serializable> {
    T saveAndFlush(T object);
}

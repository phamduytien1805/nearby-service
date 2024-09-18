package me.nearby.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public abstract class AbstractJPARepositoryGateway<E extends Serializable, T extends Serializable, ID extends Serializable>  extends AbstractRepositoryGateway<E, T, ID> implements RepositoryJpaGateway<E, ID> {

    protected abstract <A extends JpaRepository<T, ID>> A getJPARepository();

    @Override
    public E saveAndFlush(E object) {
        return getRepositoryConverter().mapToEntity(getJPARepository().saveAndFlush(getRepositoryConverter().mapToTable(object)));
    }
}

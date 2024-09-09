package me.nearby.spring.shared.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractJPARepositoryGateway<E extends Serializable, T extends Serializable, ID extends Serializable>  extends AbstractRepositoryGateway<E, T, ID> implements RepositoryJpaGateway<E, ID> {

    protected abstract <A extends JpaRepository<T, ID>> A getJPARepository();

    @Override
    public E saveAndFlush(E object) {
        return getRepositoryConverter().mapToEntity(getJPARepository().saveAndFlush(getRepositoryConverter().mapToTable(object)));
    }
}

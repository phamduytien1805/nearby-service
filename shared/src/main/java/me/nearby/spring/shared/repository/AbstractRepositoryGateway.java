package me.nearby.spring.shared.repository;


import org.springframework.data.repository.ListCrudRepository;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractRepositoryGateway <E extends Serializable, T extends Serializable, ID extends Serializable> implements RepositoryGateway<E, ID> {

    protected abstract <A extends ListCrudRepository<T, ID>> A getRepository();
    protected abstract <A extends RepositoryConverter<T, E>> A getRepositoryConverter();


    @Override
    public E getOne(ID id) {
        return getRepositoryConverter().mapToEntity(getRepository().findById(id).orElse(null));
    }

    @Override
    public List<E> findAll() {
        return getRepositoryConverter().mapToEntity(getRepository().findAll());
    }

    @Override
    public E save(E object) {
        return getRepositoryConverter().mapToEntity(getRepository().save(getRepositoryConverter().mapToTable(object)));
    }

    @Override
    public List<E> saveAll(Iterable<E> objects) {
        return getRepositoryConverter().mapToEntity(getRepository().saveAll(getRepositoryConverter().mapToTable(objects)));
    }

    @Override
    public boolean deleteById(ID id) {
        getRepository().deleteById(id);
        return true;
    }

    @Override
    public long countAll() {
        return getRepository().count();
    }


}

package me.nearby.spring.shared.repository;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface RepositoryConverter<T extends Serializable, P extends Serializable> {

    default T mapToTable(final P persistenceObject) {
        if (persistenceObject == null) {
            return null;
        }
        return mapToTableNotNull(persistenceObject);
    }

    default P mapToEntity(final T tableObject) {
        if (tableObject == null) {
            return null;
        }
        return mapToEntityNotNull(tableObject);
    }

    T mapToTableNotNull(final P persistenceObject);

    P mapToEntityNotNull(final T tableObject);

    default List<T> mapToTable(final Iterable<P> persistenceObjects) {
        if (persistenceObjects != null) {
            return StreamSupport.stream(persistenceObjects.spliterator(), false).map(this::mapToTable).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    default List<P> mapToEntity(final Iterable<T> tableObjects) {
        if (tableObjects != null) {
            return StreamSupport.stream(tableObjects.spliterator(), false).map(this::mapToEntity).collect(Collectors.toList());
        } else {
            return null;
        }
    }

}
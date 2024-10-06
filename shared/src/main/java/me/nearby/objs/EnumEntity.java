package me.nearby.objs;

public interface EnumEntity<E> {
    E getValue();

    default String getDescription() {
        return null;
    }
}

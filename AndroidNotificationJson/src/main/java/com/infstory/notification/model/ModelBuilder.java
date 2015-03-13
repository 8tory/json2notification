package com.infstory.notification.model;

public interface ModelBuilder<T> {
    public T build(Object... objects);
}

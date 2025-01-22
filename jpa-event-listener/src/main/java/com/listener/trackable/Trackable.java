package com.listener.trackable;

import com.listener.constant.EntityType;

public interface Trackable<E> extends Cloneable {
    E clone();
    String getChangeReason();
    E getSnapshot();
    void createSnapshot(String changeReason);
    Long getId();
    EntityType getEntityType();
}

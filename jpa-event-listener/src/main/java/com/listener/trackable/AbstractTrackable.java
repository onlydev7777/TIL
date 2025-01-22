package com.listener.trackable;

import com.listener.BaseEntity;
import jakarta.persistence.Transient;

public abstract class AbstractTrackable<E> extends BaseEntity implements Trackable<E> {
    @Transient
    protected String changeReason;
    @Transient
    protected E snapshot;

    @Override
    public E clone() {
        try {
            return (E) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported", e);
        }
    }

    @Override
    public E getSnapshot() {
        return this.snapshot;
    }

    @Override
    public void createSnapshot(String changeReason) {
        this.snapshot = this.clone();
        this.changeReason = changeReason;
    }

    @Override
    public String getChangeReason(){
        return this.changeReason;
    }
}

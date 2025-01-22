package com.listener.clone.listener;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EntityChangeEvent {
    private final Object trackableEntity;
}

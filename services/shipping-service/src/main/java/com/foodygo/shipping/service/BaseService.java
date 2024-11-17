package com.foodygo.shipping.service;

import java.util.List;

public interface BaseService<Entity, Key> {
    Entity save(Entity entity);

    Entity findById(Key id);

    List<Entity> findAll();

    Entity delete(Entity entity);
}

package com.morph.game.shooting.events;

import com.morph.engine.core.Game;
import com.morph.engine.entities.Entity;
import com.morph.engine.events.EntityEvent;
import com.morph.engine.events.Event;
import com.morph.game.shooting.entities.components.attacks.AttackData;

/**
 * Created by Fernando on 1/11/2017.
 */
public class DamageEvent extends EntityEvent {
    private Entity damaged;
    private AttackData data;
    private Game game;

    public DamageEvent(Entity source, Entity damaged, AttackData data, Game game) {
        super(source);
        this.damaged = damaged;
        this.data = data;
        this.game = game;
    }

    public Entity getDamagedEntity() {
        return damaged;
    }

    public AttackData getAttackData() {
        return data;
    }

    public Game getGame() {
        return game;
    }
}

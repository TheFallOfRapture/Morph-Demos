package com.morph.game.shooting.systems;

import com.morph.engine.core.Game;
import com.morph.engine.core.GameSystem;
import com.morph.engine.entities.Entity;
import com.morph.game.shooting.entities.components.Attacker;
import com.morph.game.shooting.entities.components.attacks.Attack;

/**
 * Created by Fernando on 1/12/2017.
 */
public class AttackSystem extends GameSystem {
    public AttackSystem(Game game) {
        super(game);
    }

    @Override
    protected boolean acceptEntity(Entity e) {
        return e.hasComponent(Attacker.class);
    }

    @Override
    public void initSystem() {

    }
}

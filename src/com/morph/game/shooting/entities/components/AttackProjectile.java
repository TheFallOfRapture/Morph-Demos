package com.morph.game.shooting.entities.components;

import com.morph.engine.entities.Component;
import com.morph.engine.entities.Entity;
import com.morph.game.shooting.entities.components.attacks.AttackData;

import java.util.function.Consumer;

/**
 * Created by Fernando on 1/10/2017.
 */
public class AttackProjectile extends Component {
    private Consumer<Entity> behavior;
    private AttackData data;

    public AttackProjectile(Consumer<Entity> behavior, AttackData data) {
        this.behavior = behavior;
        this.data = data;
    }

    public void applyBehavior(Entity e) {
        behavior.accept(e);
    }

    public AttackData getAttackData() {
        return data;
    }

    @Override
    public Component clone() {
        return null;
    }
}

package com.morph.game.shooting.entities.components.attacks;

import com.morph.engine.entities.Entity;
import com.morph.game.shooting.controller.Actionable;
import com.morph.game.shooting.events.AttackEvent;

/**
 * Created by Fernando on 1/9/2017.
 */
public abstract class Attack implements Actionable<AttackEvent> {
    public static final Attack NOTHING = new Attack(new AttackData(0, 0)) {public void execute(AttackEvent e) {}};
    protected AttackData data;
    protected boolean enabled = true;

    public Attack(AttackData data) {
        this.data = data;
    }

    public void enable() {
        enabled = true;
    }

    public void disable() {
        enabled = false;
    }

    public boolean isEnabled() {
        return enabled;
    }
}

package com.morph.game.shooting.events;

import com.morph.engine.entities.Entity;
import com.morph.engine.events.EntityEvent;
import com.morph.engine.events.Event;
import com.morph.engine.math.Vector2f;

/**
 * Created by Fernando on 1/9/2017.
 */
public class AttackEvent extends EntityEvent {
    public enum AttackSelection {
        ONE, TWO, THREE, FOUR;
    }

    private AttackSelection selection;
    private Vector2f mousePos;

    public AttackEvent(Entity source, AttackSelection selection, Vector2f mousePos) {
        super(source);
        this.selection = selection;
        this.mousePos = mousePos;
    }

    public AttackSelection getSelection() {
        return selection;
    }

    public Vector2f getMousePosition() {
        return mousePos;
    }
}

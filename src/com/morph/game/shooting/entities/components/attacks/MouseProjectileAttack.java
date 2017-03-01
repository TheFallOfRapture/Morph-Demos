package com.morph.game.shooting.entities.components.attacks;

import com.morph.engine.core.Game;
import com.morph.engine.entities.Entity;
import com.morph.engine.input.Mouse;
import com.morph.engine.math.Vector2f;
import com.morph.engine.physics.components.Transform2D;
import com.morph.engine.physics.components.Velocity2D;
import com.morph.game.shooting.ShootingGame;
import com.morph.game.shooting.entities.components.AttackProjectile;
import com.morph.game.shooting.events.AttackEvent;

import java.util.function.Consumer;

/**
 * Created by Fernando on 1/9/2017.
 */
public class MouseProjectileAttack extends ProjectileAttack {
    public MouseProjectileAttack(AttackData data, Game game, Entity template, Consumer<Entity> behavior, float speed) {
        super(data, game, template, behavior, speed);
    }

    public void execute(AttackEvent e) {
        Vector2f objectPos = e.getSource().getComponent(Transform2D.class).getPosition();
        Vector2f mousePos = e.getMousePosition();

        float parentSize = e.getSource().getComponent(Transform2D.class).getScale().getLength();
        float templateSize = template.getComponent(Transform2D.class).getScale().getLength();
        float size = (parentSize + templateSize) * 0.5f;

        Vector2f dir = mousePos.sub(objectPos).normalize();
        Vector2f projectilePos = objectPos.add(dir.scale(size));

        System.out.println(projectilePos);

        Entity projectile = createProjectile(projectilePos, dir);

        ((ShootingGame)game).getWorld().addEntity(projectile);
    }
}

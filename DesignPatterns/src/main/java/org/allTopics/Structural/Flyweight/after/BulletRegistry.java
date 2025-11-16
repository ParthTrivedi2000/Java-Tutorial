package org.allTopics.Structural.Flyweight.after;

import java.util.HashMap;
import java.util.Map;

public class BulletRegistry {

    Map<BulletType, Bullet> bullets = new HashMap<BulletType, Bullet>();

    public Bullet getBullet(BulletType type) {
        if (bullets.containsKey(type)) {
            return bullets.get(type);
        }
        // Please create Custom Exception later to practice Exception Handling. you can create something
        // NoBulletFoundException or something like that.
        throw new IllegalArgumentException("No Bullet with type " + type);
    }

    public void addBullet(BulletType type, Bullet bullet) {
        if (bullets.containsKey(type)) {
            // please create custom exception of BulletAlreadyExistException something like that
            throw new IllegalArgumentException("Bullet with type " + type + " already exists");
        }
        bullets.put(type, bullet);
    }

    public void removeBullet(BulletType type) {
        bullets.remove(type);
    }

}

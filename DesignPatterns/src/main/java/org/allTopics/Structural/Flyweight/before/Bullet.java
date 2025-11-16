package org.allTopics.Structural.Flyweight.before;

public class Bullet {

    BulletType bulletType;
    int maxDamage;
    double currSpeed;
    double currDirection;
    double currPositionX;
    double currPositionY;
    double currPositionZ;
    byte[] image;
    double weight;
    boolean isFired;

    // Note:- from this many attribute, we can say one more design pattern we can use here, Builder.
}

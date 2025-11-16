package org.allTopics.Structural.Flyweight.before;

/*
So we have created simply Bullet class with all the attributes. And also created BulletType enum.
Now this is client class. So our main goal is, we have to create 1000 objects of bullets ryt.
So let's do it.
- So simply for that we can run a loop to create 1000 bullet objects.
- And yes simply creation is not all ryt, we have to store it as well ryt. So we are storing it in list.


 */

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Bullet> bullets = new ArrayList<>();
        for(int i=0;i<1000;i++){
            Bullet b = new Bullet();
            b.image = new byte[]{0,0,0};
            bullets.add(b);
            // see here we can use the Builder design pattern as well. And if we have used it, then simply we can create
            // the Bullet b = new Bullet() object and then we can set the properties by b.setMaxDamage(300) etc etc and
            // then storing into list. i.e. bullets.add(b). this is how we would be doing if we have used builder here,
            // but for simplicity & since we are learning here Flyweight DP hence we haven't use it.

        }
    }
}

//- So now let's see how can we implement the Flyweight design Pattern.

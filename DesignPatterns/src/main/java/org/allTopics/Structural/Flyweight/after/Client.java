package org.allTopics.Structural.Flyweight.after;

/*


 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        List<FlyingBullet> flyingBullets = new ArrayList<>();

        /*
        // this map will behave as kind of DB. means there different kind of bullets are stored. and we will retrieve
        // from there whenever it's required.
        Map<BulletType,Bullet> bullets = new HashMap<>();

        Bullet fiveMMBullet = new Bullet();
        fiveMMBullet.maxDamage = 5000;
        fiveMMBullet.weight = 500;
        bullets.put(BulletType.FIVE,fiveMMBullet);

        Bullet sevenMMBullet = new Bullet();
        sevenMMBullet.maxDamage = 7000;
        sevenMMBullet.weight = 700;
        bullets.put(BulletType.SEVEN,sevenMMBullet);

        Bullet nineMMBullet = new Bullet();
        nineMMBullet.maxDamage = 9000;
        nineMMBullet.weight = 900;
        bullets.put(BulletType.NINE,nineMMBullet);

        Bullet zeroMMBullet = new Bullet();
        zeroMMBullet.maxDamage = 1000;
        zeroMMBullet.weight = 100;
        bullets.put(BulletType.ZERO,zeroMMBullet);

        // Now let's create the 1000 flyingBullets objects as per our requirements.
        for (int i = 0; i < 1000; i++) {
            FlyingBullet flyingBullet = new FlyingBullet();
            // but see here, the flyingBullet object is which kind of Bullet means 5MM or 9MM or 0MM or 7MM?
            // for that ideally we should give it via commandline by using Scanner, but I am currently hardcoding it.
            String type = "5";

            // Now just think like here based on the user inputted value, I want to create that type of object, then
            // which design pattern should be used here?
            // yes correct factory ryt.
            // But factory gives new object everytime which we don't want. Means what we want is, we just want to store
            // these 4 types of bullet object somewhere, and whenever it was asked it should give us the copy of that
            // object.
            // So based on our this requirement which design pattern we should use?
            // correct, prototype & registry.

            // So creating Registry for Bullets. i.e. BulletRegistry class
            // So main purpose to create it is so that we don't need to maintain those object creation into our Client
            // and instead we can get it from the registry. So now just removing/commenting out above Map code.
        }

         */

        // So instead creating Map here to store all the Bullets objects, we have created the BulletRegistry. And here
        // in the client we will create the object of BulletRegistry and register all the Bullets.

        BulletRegistry bulletRegistry = new BulletRegistry();

        Bullet fiveMMBullet = new Bullet();
        fiveMMBullet.maxDamage = 5000;
        fiveMMBullet.weight = 500;
        bulletRegistry.addBullet(BulletType.FIVE,fiveMMBullet);

        Bullet sevenMMBullet = new Bullet();
        sevenMMBullet.maxDamage = 7000;
        sevenMMBullet.weight = 700;
        bulletRegistry.addBullet(BulletType.SEVEN,sevenMMBullet);

        Bullet nineMMBullet = new Bullet();
        nineMMBullet.maxDamage = 9000;
        nineMMBullet.weight = 900;
        bulletRegistry.addBullet(BulletType.NINE,nineMMBullet);

        Bullet zeroMMBullet = new Bullet();
        zeroMMBullet.maxDamage = 1000;
        zeroMMBullet.weight = 100;
        bulletRegistry.addBullet(BulletType.ZERO,zeroMMBullet);

        /*
         Q) So one question is, why do we need to create separately registry here and storing objects there. means here
         in the client also we were doing the exact same thing, like creating map and storing objects, then how
         registry approach is better?
         Q) 2nd question is, Why do we need old instead of new objects?

         Solution:-
         See here using registry approach, we don't need to create new object everytime. means if you check in the
         registry code also, then also you came to know like for adding new object of same time we are throwing an
         exception which was not happening in the directly code in client approach. means everytime we end up with
         having new object creation which is actually consuming our memory (As we discussed in flyweight. means based
         on attribute size, it will consume memory).
         Hence if we store in registry, whenever we want to create similar kind of object (bec different Bullet object
         to mre pass 4 hi h, which we will store in the registry, but muje to mri game me i.e. client code k through
         1000 objects chahiye ryt, so instead of creating same object again and again, why not to use older one. so
         we are storing it in the registry. And whenever asked, we are giving old object only from registry. which
         will actually saves lots of memory.

         Registry = Singleton + Factory
         so in very simple terms registry is a way to serve same object over and over.


         Q) What if I want to modify the Bullet Object's registered value in registry?
         No that is kind of restriction. I mean that is why it was created so that no one can change these prototypes
         stored inside registry. if you need another prototype with modification, then you can register new one in
         the registry and start using it, and others will keep same old one to use it.
         And yes generally this prototype classes are created as Immutable class. i.e. here Bullet class should be
         Immutable since it's object should not be changed afterwards once it's created. because in such kind
         of gaming env, we are using 1000 objects of bullets, so if someone by mistakenly change/modify the
         prototype, then it will make huge impact in the game for those who are actually playing.
         So again all these things are based on requirements.

         Q) Is  the Registry class threadsafe?
         Yes the registry class is threadsafe.

         Note:- another thing is, in reality, we should use a config file and not code (if not DB) to fill the
         prototypes in the registry whenever app starts.

         So we are done with this design pattern.

         So main purpose of Flyweight Design Pattern is, to save the memory consumption at the runtime of application
         by dividing the high memory consumed classes in 2 sets of classes. 1 with intrinsic props, and 1 with
         extrinsic props.

         Note:- normally objects of intrinsic class will be Immutable and is stored in the registry.

         */

        for(int i=0;i<1000;i++){
            FlyingBullet flyingBullet = new FlyingBullet();
            String type = "5"; // get this from commandline
            flyingBullet.bullet  = bulletRegistry.getBullet(BulletType.FIVE);
            flyingBullets.add(flyingBullet);
        }

        System.out.println("Program is Done");
    }
}

/*
 Note :- Why this pattern is given name as FlyWeight design pattern?
 So generally whenever developers developing something previously at that time they used to create flyway classes
 on the go. But since as we know while something is flying, and if it has too much weights then it will be needing
 so much resources to fly ryt. so that's why what developers did is, for any flyway class whatever weights is higher
 i.e. preventing in flying smoothly, those weights they have removed and put it into another class. means now
 flyway class can easily/smoothly running/flying. So always any flying class if you observe/notice, carries
 weight as low as possible, i.e. as low objects size as possible so that it can run smoothly during runtime.
 That's why they have given name as FlyWeight Design Pattern for this pattern.
 so all the values which are changing during fly those should be keep as light as possible.

 any other real life example?
 So another example is kind of Race. you are working on a game or software in which multiple humans are performing
 race. So here as well, see main purpose of FlyWeight design pattern is to keep moving object as light as possible.
 So here if you create only single Human class, which has id,name,gender,email,phoneNo, currCoordinate,currSpeed,
 currRank etc etc... then it's actually very costly since here Human is moving object in your game/software. So you
 should keep/represent your moving object with as light params as possible.
 So you should create human class with id,name,gender,email,phoneNo and 2nd class is
 RunningHuman with currCoordinate,currSpeed, currRank properties. And now represent your moving/running person
 with RunningHuman class instead of previously used single Human class.  this is how you can think of classes
 and design pattern to optimise high grade applications.

 Note:- is it always related to something moving?
 No, it's wrong conclusion. it's always related to something classes whenever it has 2 types of properties
 intrinsic (i.e. which is fixed) and extrinsic (which is changing). there you can think of flyweight DP.
 And moving is one of the use case of flyweight, bec if you think moving object also having same 2 kind of props
 ryt, one is showing fixed/intrinsic props and another is changing/extrinsic props.

 So another use case if you want where something is not flying is,
 Zerodha :-
 it is having Stock representation ryt. so how to represent stock.
 Stock :- TickerName, lowestPrice, highestPrice, launchDate, Description etc etc...
 ticker :- Stock, currPrice, currDepth etc etc...

 */






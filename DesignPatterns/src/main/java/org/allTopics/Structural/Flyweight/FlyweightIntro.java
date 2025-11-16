package org.allTopics.Structural.Flyweight;


/*
So let's earn about flyweight design pattern.

So think about this particular case.
For example any sort of game like pubG or COD etc etc...

Now see, suppose you are creating this kind of game. for example requirement is,

- Suppose there can be 100 players in a game.
- every player can have at max 2 guns.
- every player can have bullets stored in his own bag with capacity of max 1000. So in-short given 1000 bullets per person.
- there can be 4 types of bullet. (5.56mm bullet, 9mm bullet, 0.45mm bullet, 7.62mm bullet)
- there can be 20 types of gun.
- but 1 gun can have same 1 type of bullet only at one time.

Now from above requirements, what do you think, what can be different classes we should have?
- Player, Gun, Bullet

Now currently forget about Player & Gun class. let's focus on Bullet class for now.
Now just tell me what kind of attributes bullet should have for above requirements. (Please think this as bullet
present in the frontend & flying/fired to someone)

So we can have below attributes for Bullet class ryt.

Note:- Always remember, ENUMS are always better than Strings. Because for String datatype you can make typos and also
it is not going to have compile-time checking, but in ENUMS, there are always going to have compile-time checking.
So whenever we are having fixed types, we can have ENUM class as datatype for them instead of having simply String.

Type :- Enum (5.56,9,0.45,7.62)
damage (maximum damage bullet can make) :- int
speed (current speed at which bullet is flying in the air) :- float
direction (means bullet is fired at speed 300 m/s,but in which direction?) :- float
position (so we also need position to make bullet actually move in the frontend ryt. So basically this position should be
function of speed+direction):- (x,y,z) can be simple class of 3 attributes

So to calculate the damage to the person on which bullet is fired, is depends on or should be function of max_damage,
curr_direction, curr_speed, curr_position)

Now again I would like to reiterate the problem statement:-
How a Bullet class look for a frontend of Pubg game?

So see since bullet is actually present in the frontend, so we also need something to represent as bullet ryt. So means
we need some image to represent the bullet in frontend. That's why we have to include image as well.

weight (weight of bullet):- double
image:- array of bytes/base64 string both are same means eventually base64 string is what? byte array ryt.

Now we also need to have the is_fired attribute to represent like bullet is fired from the gun & present in the frontend
or it is still in the bag of player i.e. not fired yet.

So now we are having below Bullet class.

ENUM BulletType{
    FIVE,
    SEVEN,
    ZERO,
    NINE
}

class Bullet:-
max_damage
curr_speed
curr_direction
curr_position
image
weight
is_fired

Now just tell me, how much memory single bullet class will consume?
int has 4 bytes, and double has 8 bytes in java
so max_damage-> int(4B) + curr_speed->double(8B) + curr_dir->double(8B) + curr_position->(double x, double y, double z)(24B)
image[]-> byteArray (100kB) + weight->double(8B) + is_fired->boolean(1B)
==> 100kB+53B =~ 100kB

Now see means while you are playing the game, whole code of game is inside your main memory i.e. RAM ryt that's why it is
behaving very fast while you play the game.

Now forget about other class & it's objects. means only for bullet if we are considering currently, then also
100 players * each having 1000 bullets * memory of 1 bullet 100kB ==> 100 *1000*100kB = 100*100*1MB = 10*1GB

i.e. just to store bullets, we required 10GB in memory space i.e. in the RAM!!!!!

is it feasible?
means if you create Game application with such huge memory (RAM) requirements, do you think will someone play your game?
Means if you write your code in such a bad manner then your game can never be popular ryt.

Let me tell you how online games works?
so actually there will be a server, which is storing whole game and all the objects. Now suppose 4 players are playing.
so while they are playing, server only sends Delta (only changed objects) to that particular player's device. this is
how game works. now think for only storing bullet, delta to the player is 10 GB of it's RAM in his device!!!

Now what's the solution?

So solution is, see if you observe carefully, then for all the same kind of bullets, so many from above attributes are same
it means those same attributes can be shared for/ amongst the bullet objects instead of create state of those attributes
everytime in the memory while bullet is created ryt.

So here comes new design pattern comes into the picture. which is Flyweight Design Pattern.

Flyweight Design Pattern:-
So what does flyweight design pattern says is,
Many times, when we create class diagram, we end up creating class with 2 types of attributes.
one type of attributes are intrinsic properties and 2nd type is extrinsic properties.
1) Intrinsic Properties (what intrinsic properties are?--> so intrinsic properties are going to remain same for all
the objects of a particular type)
Note:- (Good doubt) so those common attributes can be made static ryt? --> answer:- no, those could not be static
because here please see, those intrinsic attributes are common for a particular type of object like FIVE mm bullet k
liye intrinsic attributes ki value different hogi similarly SEVEN k liye bhi different hogi. so we can't make them
static bec they are same for single type but different amongst different types of objects.
2) Extrinsic Properties (those properties, which are keep on changing based on the environment/ external forces).

So what could be intrinsic and extrinsic properties/attributes for our Bullet class?
max_damage -> I
curr_speed -> E
curr_direction -> E
curr_position -> E
image -> I
weight -> I
is_fired -> E

So above max_damage is same for same type of bullets(for example 5.56mm type of bullets) ryt, so it is intrinsic
while curr_speed of any bullet is changed based on which env it is currently (water,air,any other liquid) and/or how
much distance it has covered hence due to friction speed would be decreasing in the particular environment etc etc
similar for curr_direction &curr_position which is keep on changing. But again for image and weight we are having
those attributes same for same type of bullets ryt, then for is_fired it depends on weather it's still in the bag
or not so it is also extrinsic.

So what flyweight design patterns says?
if you find you single class is having 2 types of attributes like intrinsic & extrinsic, then ideally we should divide
those all the single classes into 2 separate classes.
            Bullet
            /   \
           /     \
        Bullet   FlyingBullet/MovingBullet (Only contains Extrinsic Props.)
(Only Intrinsic Props.)


So now just tell me,suppose player has fired the bullet, now when you are representing that bullet in the frontend
that should be of object of Bullet or FlyingBullet?

So you said flyingbullet.--> correct --> then how to have the image for that object representation bec image attr is
present in the Bullet, then how to get it? --> so you are saying to inherits flyingBullet class to Bullet class.

No it's incorrect. So this is where you are making mistake. means if you use the inheritance, size of the objects
of the child = size of the attributes of child + size of the attributes of parent
bec all the attributes are copied for each object instance in case of inheritance.

So if you use inheritance,  we haven't saved space, then again we are at same memory problem step.

Solution :- correct so solution is to use the Composition. means we can have reference of the Bullet class in the
flyingBullet class.
So now what will happen is, if you want to show image of flyingBullet object in the frontend, you can access image
in this way:- flObj.getBullet().getImage();

Now let me explain you how above thing (i.e. composition) saving memory here?
so currently FlyingBullet class --> curr_speed, curr_dir, curr_position, Bullet bullet
and Bullet class --> max_damage,image,weight

Now see carefully. when we are running the program in memory, how many Bullet types objects is there in memory?
--> 4 ryt means we are having 4 different types of Bullet. hence we are having only 4 Objects of Bullet type class.
i.e. 4 obj * 1 Bullet class size
Now see what is the size of single Bullet class? --> 100kB+16B ~= 100kB
total memory occupied by all the 4 different Objects of bullet = 4 * 100kB = 400kB

Now we are representing fired bullet as Flyingbullet ryt. So in worst case suppose all the players have fired the
bullets and that is also all the bullets. So
100 * 1000 * FlyingBullet class size

So what s the size of 1 FlyingBullet class?
curr_speed (8B) + curr_dir (8B) + curr_pos(24B)
+ Now what is the size of Bullet reference?

see understand this, this is not whole Bullet Object, but reference is only single memory address which
represents the address of another object. so the memory which reference takes place depends on the JVM/machine
you are using. but means either 32bits or 64bits depending upon the configuration of memory of our laptop/pc/device.
So if 32 bits then 4B, if 64 bits then 8B.
Suppose if we think as worst case, then you are having 64 bits configured machine. it means 8B

So 8B+8B+24B+8B = 48B
so finally what is the size of single FlyingBullet object --> 48B

so total space occupied by all the FlyingBullet objects are = 100*1000*48B =100*48kB = 4.8MB cool!!!

And total overall space occupied by all the things regarding bullet = all the obj of Bullet + all the obj of FlyingBullet
400kB + 4.8MB = 0.4MB+4.8MB = 5.2MB !!!

so we require only 5.2MB in RAM instead of 10GB of RAM for storing/representing bullet objects in our game.


Conclusion :-
So Flyweight design pattern says, if you identify that because of the way you put the attributes in your classes, you
might end up with memory/storage issues, then consider dividing that class into 2 different classes. one Moving/Flying
class which only contains extrinsic attributes, and one Fixed class which should holds the only Intrinsic properties.

Note:- So here since numbers were given in the requirement hence we came to know like we should go for flyweight
design pattern due to higher memory consumption. But what if it won't given? Then how we came to know like here we
need to implement the flyweight design pattern.
So actually the thing is, while you are doing profiling/monitoring of your application, at that time you came to know
like there are this kind of objects present which is taking more memory in RAM etc etc....and then you refactor/
optimise your code ryt.




 */

public class FlyweightIntro {
}

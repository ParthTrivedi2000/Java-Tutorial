package org.allTopics.Behavioral.Strategy;

/*
What do we understand by the term Strategy? (not in terms of design pattern, but in general).
- Plan to do something ryt.
- Algorithm to do something.
- Way to do something.

So in the world of Computer Science, Strategy means Algorithm to do something/ Way to do something.

Now just tell me, when we are doing something, will there be only 1 way to do that thing?
- No there can be multiple ways to do that particular thing.
It means can I say that, There can be multiple Strategies to do that particular thing. say yes or no? --> yes
So this is how you should remember the Strategy Design Pattern.

Means When should Strategy Design Pattern comes to your mind?
- So whenever you see some Behavior, for which there can be potentially multiple ways to do that particular thing
in future, you should think of it as Strategy. So Strategy is nothing but a way to do something.


Let's understand it via practical example.

For example, you are using Google Maps. Let's say I want to find the route between Ahmedabad to Banglore.
So it is but obvious that there might be a algorithm/ there must be a way/ there must be a Strategy
in backend google to find root between this 2 cities ryt.
Now how many of you think, there might be multiple strategies available to find the route between these 2 cities?
And what are those?
- So if you have seen in google maps, there are multiple routing strategies available based on mode you are choosing.
for example, it will show you different route/path if you choose to go via Car, different if you choose walking,
different if you choose bike, different if you choose public transport.

car -->
bike-->
walk-->
publicTransport-->

That means Google Maps has multiple ways/ multiple strategies to find that path between Ahmedabad to Banglore.

Now let's try to think code of above Google Map implementation.
class GoogleMaps{
    findRoute(String source, String Destination, String modeOfTransportation){
        if(modeOfTransportation == "car"){
            // some way
            // go via this way
        }
        else if(modeOfTransportation == "bike"){
            // some way
            // go via this way
        }
        else if(modeOfTransportation == "walk"){
            // some way
            // go via this way
        }
                ......
                |
                |
                etc etc
    }
}

Above might be the simplest solution we can think of.
But if you see in above case, there are 2 principles violating here. SRP & OCP.

So let's try to think about the Solution.:- which is Strategy Design Pattern.

- So when we start learning Object Oriented Programing, this is the way we were learnt to represent everything
in terms of Object.
- Means Every Entity should be a Class. And if entity has any behavior, then every Behavior is represented as Method
of a class.
But issue arises when behavior is getting changed, when behavior becoming more complex. then how will we handle
the situation?
- So in this case, Strategy design pattern help us.
- In that case Strategy Design Pattern says, create an interface for the thing that you want to do. i,e, for that
behavior.
-i.e. over here, we are finding route ryt. So create a interface RouteFindingStrategy. And inside it create the
generic method for that thing/behavior.
i.e.
public interface RouteFindingStrategy{
    findRoute(String source, String Destination);
}

- And for every different Way/Strategy to perform that behavior, create a separate class
which implements that strategy.
public class CarRouteFindingStrategy implements RouteFindingStrategy{}
class WalkRouteFindingStrategy implements RouteFindingStrategy{}
etc etc...

- So what we have learnt, we can have interface for strategy, and for each way/strategy, we can have different
classes.

Now see above code of Google Map class, means still method is there. I mean how that method can be changed. means
there we are passing mode ryt. Mode is what ? --> mostly ENUM ryt. so based on different String/ENUM, I want to have
different class objects, how to get that?---> yeah absolutely correct, Factory ryt. We need to have Factory, a Simple
Factory which has the factory method, which took Mode as input, and provide us the correct class object as per our
need.

- So we need to create the Factory class,
class RouteFindingStrategyFactory{
    static getStrategyByMode(Mode){if else wala logic};
}


- So generally, not generally but most of the time, your Strategy Design Pattern might associated with the Factory.
So now your above Google Maps code will be something like this.

class GoogleMaps{
    findRoute(String source, String Destination, String modeOfTransportation){
        return RouteFindingStrategyFactory.getStrategyForMode(modeOfTransportation).findRoute(source,destination);
    }
}

Simple!!!

- Now if you have requirement of adding new Strategies, then simply you can have new class for that strategy which
need to implement the above strategyInterface, and you are done. you don't need to modify anywhere in the existing
code.

Doubt:-
Q) I faced similar scenario in an interview, the interviewer said having if else in other class will again violate OCP,
ryt?
--> Solution :- No, that factory class is meant for that purpose, those if else were part of business logic basically
to identify the correct object for correct ENUM type. And even that 1 single responsibility is given to that class ki
identify the correct type and return object for that type, now in previous case also if/else were there but that
is again putting extra responsibility on the existing class, bec existing class has it's own separate responsibilities,
and if we keep if/else inside the same class, then it will be an extra responsibility to that existing class to identify
correct object and getting corresponding object for that.

- Now see our main application code base (Google Maps codebase), that class is not violating OCP ryt. means main
application codebase class is not violating principle ryt.

means the only benefit of Factory pattern is, your application codebase need not to be changed. See via implementing
Design Patterns, we are trying to make our Application's main codebase to make modular/ decoupled.

Q) I have tried to put the same answer, but interviewer is not agreeing.
He said I should rather have a hashmap of modes in this case, have a modes interface and specific classes for modes.
- yes so there is another way to have Factory pattern. which uses Registry. but since we haven't covered Registry
pattern, please wait till Registry covered.
(For me, pls go through this link to check Factory using Registry Design Pattern:-
https://www.scaler.com/topics/design-patterns/factory-design-pattern/
)

Q) If types of Modes increasing time to time, then factory will also keep increasing?
- yes


Q) What is the difference between Strategy & Factory?
- So 1st of all,
When to use the strategy design pattern?
-you should use the strategy, whenever you find yourself in a situation where there are Multiple ways to do something.
for example suppose there are multiple ways to Fly (recall above discussion, we need to create interface for what you
want to do/ or behavior, then for each way/strategy we need to create separate class),
then you should use Strategy.
Now, How to use Strategy in this case? --> 3 steps.
- 1) create an interface for fly --> flyingStrategy.
interface FlyingStrategy{
    fly();
}
- 2) create class for each flying way,
class SlowFlyingStrategy implements FlyingStrategy{
    fly(){
        //something
    }
}

class FastFlyingStrategy implements FlyingStrategy{
    fly(){
        //something
    }
}

- So till here strategy pattern is over. this is how we use Strategy Design Pattern, which we already understood.
But now, how will you use these different strategies inside your Client code/ Application's main class code? where
actually you want to plugin this code., how will you plugin this in your client code?
- So to plugin the code, we need to use the Factory.

Q) so factory in itself can be around entities( vehicle , car, bus) or it can be around behaviors, so strategy
revolves specifically around behaviors ?
- yes, so that's what we have discussed firstly like previously what we thought is, only every entity should be a
class ryt, behavior should not be a class, but it should be a method inside class. But with Strategy design pattern
sometimes behaviors can also be a class (for example:- SlowFlyingStrategy, FastFlyingStrategy), bec slowflyingstrategy
is not an entity but it's a behavior ryt. but still it is a class above see.
And yes we can have a Factory for anything, anyclass.


- Now as per our discussion above, our client is depending on the Strategy Interface(here RouteFindingStrategy) ryt.
So basically I want to inject this RouteFindingStrategy. so other which design principle I should use?
-Dependency Inversion is already using above (how?--> see we are coding directly to an interface, not to any concrete
class.
- Yes correct, so we can use Dependency Injection principle here to inject the dependency externally to the client.
(Anyhow client ko mtlb h sirf uske pass RouteFindingStrategy type dependency hona).


- Now for example Use Case is something like (below 3 points milke 1 usecase represent kr rhe h):-
1) In google Maps, there are multiple ways to calculate Path/Route.
2) But at one time google map will only use any 1 of those ways for everyone
3) So means now there is no need of Mode to provide in the findRoute() method, bec only any of the 1 way is served to
everyone. Bec now, Way/Mode that needs to be used  is given via config at the time of Application starting.
So now in above usecase, how can I basically construct my GoogleMaps class?

- So I can have GoogleMaps class which basically has the attribute of type RouteFindingStrategy strategy;
class GoogleMaps{
    private RouteFindingStrategy strategy = new CarRouteFindingStrategy();
}

But in above case, suppose if I need to change the strategy in future, then what? --> then I have to modify my
Application's main class (but we have discussed ryt, we never ever ever wants to modify our Application's main
class, means majorly hmari almost design pattern principles bhi hmare Application k main class ko
robust/modular/decouple (as loosely couple as possible) bnane ki try krte h taki usme koi changes na krne pde in any
case (means in most of the case).

- So yes we should use the Dependency Injection Principle here. Now how can we inject dependency here?
- we can create the constructor and pass the dependency inside it ryt (why?, bec tb since my this main class's
code is dependent on something, so if we use constructor injection it indecates that, my Application (here Google Map)
is dependent on this dependency so it is mandatory to have this dependency/object to start/working object of this
application(google map).
- And who will provide this dependency inside the constructor?
Runner/Driver class ryt. means Main class which is having static main method, (or whichever class which wants to use this
Application's object(i.e. Google Map's Object) that class needs to provide the required dependencies 1st.

class GoogleMaps{
    private RouteFindingStrategy strategy;

    public GoogleMaps(RouteFindingStrategy strategy){
        this.strategy = strategy;
    }
}

- And how Driver class can find the correct strategy?
It will read from/via config file.



So above we have seen, there are 2 ways via Stragegy Pattern can be made working.
1) one is to use the Factory. means provide the mode, & on basis of that ask factory to give correct dependency object.
2) 2nd is to provide the Strategy via config, via constructor.


Let's task 1 more practical example of above 2nd type, in which dependency object is given via constructor.

- For example there is a Service called UserService. which can have multiple behaviors. Now 1 of the behavior is signup.
UserService{
    login();
    signup();
}
- Now tell me what all things are generally required as arg in the signup() method. username, password,email ryt.
Now you have to store it into the DB. But to store in DB, for password you are not directly storing it into DB bec
of security purpose.
- But instead 1st you encrypt the password by HASHING + SALTING. which provides security that anyone else can't directly
read your pwd by hacking the db.
- Now tell me, can there be multiple ways to HASH a password? can there be different HASH algo?(like md5,rsa,sha etcetc)
yes so there can be many HASHING algo. so my UserService class needs to have an instance/object of HASHINGAlgo or
HASHINGStrategy or we can say PasswordHashingStrategy.
- And how will UserService get it?--> via it's constructor ryt.

UserService{
    private PasswordHashingStrategy hashAlgo;
    public UserService(PasswordHashingStrategy strategy){
        this.hashAlgo = strategy;
    }
    login();
    signup(username, password, email);
}


- So now you might understood, real world usecase of when to use strategy.

Conclusion:-
When to use the Strategy?
- Whenever there can be multiple ways to do a behavior, just abstract out the behavior from the entity class and
create the separate class for the different ways of behaviors.


Note:- Whenever we are using @Autowire in spring, actually we are using Strategy. (Just corelate with above usecase)

- Now if you recall that bird class example, in bird class, there is a point where we end up having fly() behavior,
but there is no few birds in like penguin which can't fly, ie. actually it doesn't have flying behavior.
So in that case we can have separate Flyable Interface, And whichever birds can fly those only should implement
it.
- But now issue is, 3 birds (pegion, crow, sparrow) having same Flying behavior, And another 2 birds(Hen,Peocock) having
same Flyable. So here there is issue of code duplicacy (bec we can have so many class which is having this
same behavior ryt).
- So here is the solution. here you can use the Strategy. means just try to correlate how we come to this point?
(just think here 1 behavior can have multiple ways, I mean different entities are providing multiple behaviors & few
of them needs same behaviors)
That's why we can think of a Strategy pattern here.

- So we can have FlyingBehavior interface. And 2 concrete class, 1st is QuackFlyingBehavior(which basically implemented
by Hen & Peacock) and 2nd is CrogenFlyingBehavior class(for crow & pigeon).
- So now my Hen class should have 1 attribute called FlyingBehavior & it needs to take it via argument in the constructor
And just see below how it can implement the fly behavior via Flyable. & using FlyingBehavior interfaces's type dependency.


class Hen{
    private FlyingBehavior flyStrategy;
    public Hen(FlyingBehavior strategy){
        this.flyStrategy = strategy;
    }
    public fly(){
        this.flyStrategy.fly();
    }
}

Hen = new Hen(QuackFlyingBehavior);



Doubt:-
Q) but, this increases the complexity right? for each such behavior, we would have different "Behavior" interfaces.
- Yes but samne 2 advantages il rhe h, other lot of complexity reduces + Code duplicacy resolved. And else as always
there are always tradeoffs in System design.
Q)
- Hen class is not implementing FlyingBehavior. See carefully. Hen is Implementing Flyable bec it can fly,
but Hen class Has a FlyingBehavior bec in that way it is flying. So there are 2 different purposes of these 2
things that's why Hen class is constructed in that way. (means we haven't studies IS-A (inheritance) &
HAS-A (Association-composition)) yet. else you would get very wall the diffn between 2).

Q) Flyable Interface should extend Flyable, but you haven't.
- No. just go to the Interface segregation principle says, every interface has separate purpose. The purpose of
Flyable behavior is to depict the birds that can fly. While FlyingBehavior depicts how actually birds can fly.
So are they same --> obviously they are not same as they serve different purposes. even though both interface have
the same method name fly(), but each interface is for different purpose, you can change the method names as per
your wish.

Q) Then with above structure of bird class, how we will get all the birds that can fly?
- simple by creating List<Flyable> you can get all the flyable birds.

Q) what if we want to filter objects based on the strategy used, all the birds that will flySlow?
- No, With above code, it's not possible, for that you need some extra attributes (I think as dependency or
in other way).

Q) why cant we use the java enum class for it where we can define methods for enum value?
- Yes, we can do it, but technically ENUM is not available in all the languages, so if code needs to refactor in
different languages, we should code it out in terms of class/interfaces and all those things.


Again in simple terms
Conclusion of Strategy PAttern:-
- In Strategy Design Pattern, Behavior is extracted out from an Entity class to a Separate class. And then the
current Entity class just delegates to the behavior class (for example, in Hen we are not writing impl of fly behavior
bt delegating it to behaviorclass).


 */

public class StrategyPatternIntro {
}


/*
Difference between Strategy Design Pattern vs Adapter Design Pattern ?
- Adapter is basically a Structural Design Pattern.
- So Adapter Design Pattern says,
when you want to connect to a 3rd party API (here why it's 3rd party? bec you can't control/ can't have control on
their interface, 3rd party themselve can structure their API in whatever they want ryt, you can't control it's
interface),
So in this case where your class is directly dependent upon 3rd party API class then what will happen/ or what will
happen in future?
now let's suppose you want to move away from that 3rd party API, then you need to change hell lot of code changes
in you class. bec you have used everywhere that 3rd classes dependencies directly. Hence at all those places where
you are using 3rd party API classes' attributes, methods/method calls all of these things needs to be modified in my
class. And that is only in the single class file, now certainly I will be having lot's of different class files
available in my Application/project which is using the same 3rd party API's class dependency directly, so all those
places needs to be modified.

So how to solve above issue?

Solution:-
- 1st of all above is a violation of DI(Dependency Inversion), bec 2 concrete classes are directly depends on each
other.
- 2nd issue with above impl is, we need to do change at lot of places in case of want to modify the 3rd party API
to another 3rd party API/or your own created API in future.

How to solve this?
-So obviously since it is violating the DI, we will solve it by 1st creating Interface between my class & 3rd party
API.
class --> Interface --> 3rd party (for example Bank API)

class --> BankAPIInterface --> 3rd party API

- Now since it is your own codebase, so you can modify/create/delete anything. but now to have implement of above
interface, hm log 3rd Party ko to nh bol skte ki can you please modify your API by implementing this our BankAPIInterface
ryt. So just mean to say is, think here in my you have fixed 3rd party API classes/methods inside it (you can't change
them anyhow) & left side you have created something which will be actually implemented by lots of more classes in our
own application code. So obviously here to have connection between both of this (left side interface & right side
fixed 3rd party API structure), you need to create the some wrapper which eventually wraps the 3rdp party API structure
i.e. methods in the desired format of our created BankAPIInterface.
- Basically there should be class in between which will transform 3rd party API classes to the our application's
interface.
This wrapper class is also called an Adapter class.

class --> BankAPIInterface --> YesBankAPIAdapter --> YesBankAPI(3rd party API)

obviuosly here we can use as many 3rd party bank API like ICICIBankAPI, HDFCBankAPI etc etc...but due to limitation
of not able to drw here I am not mentioning it, but just think in mind like we can have multiple Adapter classes
which implements the BankAPIAdapter.

Where as what is the Strategy Pattern?
- So as if you focused above, Adapter is used to connect with the 3rd party API, since we do not have control
on their API Codebase.

whereas Strategy is of type behavior Design Pattern. Here it's type only tells, see it's type is behavior design
pattern it means it's type says/indicates that you should use these behavioral design patterns when something is there
around the behavior.
So use strategy design patterns when there are multiple ways to do something. In that particular case, rather than
having whole code in the single Entity class, you separate out the behavior related code.
So in codebase, my Entity class will not be having behavior/ways of behaviors code in the same class, instead behavior
code will be in a separate implementation of an interface class. So there will be an BehaviorInterface, and there will
be multiple different behaviors as a class implementing that behavior interface. And my Entity class will be having
this Behavioral Interface as a dependency in it's entity class file.

So simply both the design patterns serves whole different purposes, like Adapter is structural design pattern
which generally will be used when we deal with 3rd party APIs,
while Strategy is a Behavioral design pattern which generally used when there are multiple behaviors.

Means remember this point as well, in Adapter if you see, you are just connecting you application to the 3rd party
API, you are not actually providing the implementations ofbehaviors. But in case of Strategy you are providing
the implementations of behaviors, basically you are responsible to provide the how-to-do but in case of Adapter
3rd party is providing how-to-do part, you are just providing a way to get those APIs/how-to-do things in your
application codebase.

Doubt:-
Q) If we have multiple bank apis at the same time, can we use strategy dp to get the right bankapi instance?
- No, if you need right/correct instance, then you will need to use Factory ryt not strategy. Recall, even in the
strategy design pattern also whenever we want to have correct/right instance of strategy, we have used Factory
design pattern.


 */
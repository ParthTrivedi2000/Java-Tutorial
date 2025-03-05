package org.allTopics.Creational;

// SingleTon Deign Patterns :-

/*
So as singleton pattern is creational design pattern, it is related to how object is created.

when to use singleton?
- So whenever in our project, if you want to create (instantiate) object only 1 time in your whole
project and then you want to keep using the same object only in that case you Singleton Design Pattern
is used.
- Means suppose for example:- DBConnection. So always we need to work with DB ryt while working on any of the
project. And during whole project if you want to perform continuous CRUD operation with DB during different
classes and interfaces (i.e. in short in whole project), then it is advisable to create CONN (connection)
object only once, instead everytime you create connection object and do the same thing again and again.And
also why to waste space of memory as that object is doing the same thing for all the classes in whichever it was
created, like just to establishing connection.

- So suppose I am having Object ob, and I want to use it 3-4-5-10 times in my project but i don't want to create
the same object 3-4-10 times, but instead I want to create it only 1 time and want to use it multiple time
during my project, then SingleTon Design Pattern comes into the picture (hence the name as it is only creating
the object 1 time and allow us to use the same object multiple times so known as SingleTon Pattern).

- Object which is created single time is known as Singleton Object.
(So abhi aapke dimag m ek hi cheeze honi chahiye ki, mri puri application m ek hi object hoga and ussi ko m bar
bar use krunga)

Point 1)
- So suppose I am having class:- samosa, and I want ki ye class ka only 1 hi object create ho means 1 hi bar
m instantiate kru and then meri puri Application m wo same hi object use ho. let's see how?

- Now whenever we are creating any object of any class, then always wo class ka constructor call hota h ryt.
and since wo constructor public hota h so we were able to create class in any other packages except that file.
so hm log wo constructor pe hi rock lga de then we can achieve something.

public Samosa{
    public Samosa(){
    }
}

public Main{
    public static void main(String[] args){
        Samosa mySamosa = new Samosa();
        // so as soon as above lines runs, Samosa() constructor will be called. And mySamosa named object will
        // be created.
    }
}

// But now suppose, you have made constructor as private then what? --> then I can't call that constructor
outside of the class ryt. means it will give error. So what you have done, you have prevented object
instantiation from any other classes for the class Samosa.
public Samosa{
    private Samosa(){
    }
}

- So 1st very imp point to remember for Singleton design pattern is, make constructor as private (why
private, bec I don't want let anyone to create the object for this class as I want to have only 1 object
for whole application hence keeping my constructor as private.


Point 2)
- Now since we have made that object as private, I can't instantiate/create the object from anywhere
outside the class Samosa ryt (recall private access modifier's property). But anyhow we have to return the
Object at least 1 time ryt. so I can have only 1 option left that is to create object inside the class
and return it via method call from outside of the class ryt.
public Samosa{
    private Samosa(){
    }

    public Samosa getSamosa(){
    }
}

- So above we have created the method getSamosa(). Now whenever anyone wants object of Samosa, they can't
instantiate/create object Samosa. but instead they have to call this method And they will get the object Samosa
as a return value.

- But wait, like how to call this method? means to call method of any class, we need object ryt? and object to
hm bna nh skte h for this particular class. then how to call this method? --> so answer is since we don't want
this method to be called with any object name, instead we want method to be called from any class, so we can
create this method as static.

public Samosa{
    //constructor
    private Samosa(){
    }

    public static Samosa getSamosa(){
        //object of this class
        Samosa mySam = new Samosa();
        return mySam;
    }
}

- But now issue with above code is, what if someone call this method multiple time. for example 5 times, then
samose k 5 objects create ho jayenge ryt. which we don't want. muje to mri puri application m ek hi bar samosa
ka Object create krna h and usko hi multiple times use krna h.

- So what we can do is, we can create an object typed Samosa inside the Samosa class. (And we also have to
keep it as static otherwise usko hm jb static method m use krenge tb error aayegi ki non static variables can
not be used in static context so we are creating this variable also a static). So hm kya krenge ki simply
ek check lga denge, ki ye variable samo me koi value aa chuki h ki nh. agr nhi aayi h means null he to hi
hm new Samosa() object create krke assign krenge else simply usi ko return kr denge.

public Samosa{

    private static Samosa samo;

    private Samosa(){
    }

    public static Samosa getSamosa(){
        // since static variable has by default value null if it's non primitive.
        if(samo == null){
            samo = new Samosa();
        }
        return samo;
    }
}
 */


//class Samosa{
//
//    private static Samosa samo;
//
//    private Samosa(){
//    }
//
//    public static Samosa getSamosa(){
//        // since static variable has by default value null if it's non primitive.
//        if(samo == null){
//            samo = new Samosa();
//        }
//        return samo;
//    }
//}


//public class Singleton {
//    public static void main(String[] args){
//
//        // creating object from className instead of new Samosa()
//        Samosa samosa1 = Samosa.getSamosa();
//        Samosa samosa2 = Samosa.getSamosa();
//
//        // object.hashCode():- this method is used to check the object's actual location/memory name in memory.
//        System.out.println(samosa1.hashCode()); // 1791741888
//        System.out.println(samosa2.hashCode()); // 1791741888
//
//        // above you can see, hashcode of both the objects are same. ie.e both the objects are actually single
//        // object only which is Samosa().
//    }
//}

// Above method to create SingleTon Class and SingleTon object is known as Lazy Initialisation. bec yha pe
// jb client ko (i.e. here Main method) ko jarurat thi tbhi aapne call kiya.

// So hmne above jo singleton class and object bnaya is known as Lazy way. bec jb tk client h wo call nh
// krega tb tk it won't get it. means jb client ko jarurat hogi tb wo pehlei bar call krega tb aap provide
// kr rhe ho. So a way in which object is created whenever there is requirement is known as lazy way
// of creating object. But there is another way Eager way to create Singleton class and object. Let's
// see it.


// In eager way of creating singleton object, what we are doing is, we are directly initialising the
// private static variable with the object in the class. And then we are returning it whenever getJalebi()
//method is called. See below code for more information.



class Jalebi{
    private static Jalebi myJalebi = new Jalebi();
    private Jalebi(){

    }
    public static Jalebi getJalebi(){
        return myJalebi;
    }
}

public class Singleton {
    public static void main(String[] args){

        // creating object from className instead of new Samosa()
        Samosa samosa1 = Samosa.getSamosa();
        Samosa samosa2 = Samosa.getSamosa();

        // object.hashCode():- this method is used to check the object's actual location/memory name in memory.
        System.out.println(samosa1.hashCode()); // 1791741888
        System.out.println(samosa2.hashCode()); // 1791741888


        System.out.println(Jalebi.getJalebi().hashCode()); // 1072408673
        System.out.println(Jalebi.getJalebi().hashCode()); // 1072408673
    }
}


// What is the Difference between Lazy way and Eager way of creating Singleton classes?
// Or what is the advantages and disadvantages between both of them?

/*
- So eager way me hm kya kr rhe h, ki we are initialising static variable. And whenever class loads
static variables are automatically loads 1st. So in Eager Way, whenever class Jalebi loads, automatically
my jalebi() object will be instantiated (as we have called bec static variables automatically got called or
initialised during class loads) and assigned to the myJalebi static variable.

- So here disadvantage in Eager Way is, like my client(here Main method) never wants to use the jalebi()
object. hence even it has not called single times, but still singleton using eager way has created it.
And remember in our Application/Project, we will be having lots lots of singleton objects. So this way
can degrade the performance.



Now what is the problem with Lazy Loading?
- So in lazy loading what happens is, whenever client calls the  method 1st time at that time only object
will be created and return back. and from next time onwards whenever client calls, it will get the same object.
But here we haven't focus or consider Threads. means here only 1 thread is there. So if in your case if there
is no concern of Thread Safety, then you can 100% use the Lazy Way of SingleTone Pattern to create the objects.

- But if there are multiple threads working in your application, then suppose any 2 threads ne sath me wo
samosa.getSamosa() call kr diya and dono thread wo sampsa class ki wo method call p chle gye then there
will be 2 Objects instantiate ryt and which will violate our SingleTon Pattern principal of creating once and
use it multiple time. So we have to handle it ryt?

- One way is we can use the Synchronized keyword in the method declaration. what that keyword will do is,
if 2 threads simultaneously wo method call pr pahuchenge and hmne wo method p synchronized keyword lgaya h,
then koi ek hi thread at a time wo method ko execute kr payega and dusra thread 1st trhread k complete hone
ka wait krege. And after competion of 1st, 2nd thread start calling the method and uss tym pe mari if
condition false ho jayegi and dusri bar object create nh hoga.

class Samosa{
    private static Samosa samo;
    private Samosa(){
    }

    public synchronized static Samosa getSamosa(){
        if(samo == null){
            samo = new Samosa();
        }
        return samo;
    }
}

- But problem with Synchronized method in above case is, hmne yha pe itna 6ota code likha h. but in actual
case me to bahot bda code hoga isme. To sirf ye upper ki line samo = new Samosa();  ki vjh se thread 2 ka
execution stuck ho jayega jb tk thread-1 pura execute nh ho jata uspe. So kehne ka mtlb h ki we don't want
to synchronize all the lines of method. instead we want to let the treads work simultaneously on all the
lines of the method except only this line.

- So above we have used method synchrnization ryt. But now we don't want that to be used instead we will use
synchronize block to make only few line of code to be synchronised, not whole method. See below code in case
of multiple thread/or thread safety.
 */

class Samosa{
    private static Samosa samo;
    private Samosa(){
    }

    public static Samosa getSamosa(){
        if(samo == null){
            //till this line if any 2 threads reach simultaneously, then there is no problem. But after this
            // we have to check if object is not created previously by any of the threads then only I want
            // to create so that has been taken care by if condition and only 1 thread at a time can enter/or
            // hit the synchronised block is taken care by synchronised() block.
            synchronized (Samosa.class){
                if(samo==null){
                    samo = new Samosa();
                }
            }
        }
        return samo;
    }
}


// So now next thing is can we break the SingleTon Design Pattern?
/*
- Yes we can break the singleton design pattern.

So basically what is preventing from creating multiple objects in singleton design pattern?
- private constructor ryt. so if somehow I am able to reach that constructor, and I can make change the
access modifier of that constructor from private to public then we can create multiple objects or we can say
break the singleton pattern.
-So yes there is Reflection API present in Java using which you can access the properties of any class
dynamically and you can modify.

Below are the ways to break the SingleTone Design Pattern.
1) Reflection API
public static void main(String[] args){
        Samosa samosa1 = Samosa.getSamosa();
        System.out.println(samosa1.hashCode());

        Constructor<Samosa> constructor = Samosa.class.getDeclaredConstructor();
        constructor.setAccessible(true); // changing modifier from private --> public

        Samosa s2 = constructor.newInstance();
        System.out.println(s2.hashCode());

    }

So with the above code you will be able to break the SingleTon Design Pattern easily.
So now how to prevent from this breakdown of singleton design pattern.

- Solution-1:- if object is there --> throw exception from inside constructor. (see below code)
class Samosa{
    private static Samosa samo;
    private Samosa(){
        if(samo!=null){
            throw new RuntimeException("You are trying to break the SingleTon Design Patter");
        }
    }
    public static Samosa getSamosa(){
        if(samo == null){
            synchronized (Samosa.class){
                if(samo==null){
                    samo = new Samosa();
                }
            }
        }
        return samo;
    }
}

- Solution 2:-  use enum

enum Samosa{
    INSTANCE;
}
public static void main(String[] args){
        Samosa samosa1 = Samosa.INSTANCE;
        System.out.println(samosa1.hashCode());

        Constructor<Samosa> constructor = Samosa.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Samosa s2 = constructor.newInstance();
        System.out.println(s2.hashCode());

    }
 */

/*
2) 2nd way to breakdown the SingleTon Pattern is Deserialize the object after serialization.

video - completed 47:00 mins...

3) by Object Cloning also singlton pattern can be broken.
public static void main(String[] args) throws Exception, CloneNotSupportedException{
    Samosa samosa1 = Samosa.getSamosa();
    System.out.println(samosa1.hashCode());
    Samosa s2 = (Samosa)samosa1.clone();
    System.out.println(s2.hashCode());
}

class Samosa implements Cloneable{
    private static Samosa samo;
    private Samosa(){
        if(samo!=null){
            throw new RuntimeException("You are trying to break the SingleTon Design Patter");
        }
    }
    public static Samosa getSamosa(){
        if(samo == null){
            synchronized (Samosa.class){
                if(samo==null){
                    samo = new Samosa();
                }
            }
        }
        return samo;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}


- Solution to prevent breaking, is to simply return the samosa object while overriding the clone() method.
class Samosa implements Cloneable{
    private static Samosa samo;
    private Samosa(){
        if(samo!=null){
            throw new RuntimeException("You are trying to break the SingleTon Design Patter");
        }
    }
    public static Samosa getSamosa(){
        if(samo == null){
            synchronized (Samosa.class){
                if(samo==null){
                    samo = new Samosa();
                }
            }
        }
        return samo;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return samo;
    }
}
 */

/*
Q.How
 to break a Singleton pattern ?

While the Singleton pattern ensures only one instance of a class, several techniques can break this pattern, leading to multiple instances. Understanding these vulnerabilities is crucial to prevent them.

Ways to Break Singleton & Fixes

1. Reflection
 - Reflection can be used to bypass the private constructor of a singleton class, allowing the creation of multiple instances.

Example:
Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
constructor.setAccessible(true);
Singleton instance2 = constructor.newInstance();
Fix: Throw an exception if an instance already exists.
private Singleton() {
 if (instance != null) {
 throw new IllegalStateException("Instance already exists!");
 }
}

2. Serialization & Deserialization
- During deserialization, a new instance of the singleton class can be created, breaking the singleton pattern.
Example:
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"));
Singleton instance2 = (Singleton) ois.readObject();
Fix: Implement readResolve() method.
protected Object readResolve() {
 return instance;
}

3. Cloning
 - If a singleton class implements the `Cloneable` interface, calling `clone()` on the instance can create a new instance.
Example:
Singleton instance2 = (Singleton) instance1.clone();
Fix: Override clone() to throw an exception.
@Override
protected Object clone() throws CloneNotSupportedException {
 throw new CloneNotSupportedException("Cloning not allowed");
}

4. Multiple Class Loaders
 - If a singleton class is loaded by different class loaders, it can create multiple instances.

 **Mitigation:**
 Controlling the class loading environment is necessary to prevent this.

Fix: Use a global class loader or an Enum Singleton.
public enum Singleton {
 INSTANCE;
}

In Short :

Reflection: Prevent by checking existing instance in the constructor.
Serialization: Use readResolve() to return the existing instance.
Cloning: Override clone() to prevent cloning.
Class Loaders: Use an Enum Singleton for safety.
Ensuring a robust Singleton requires addressing these vulnerabilities to truly guarantee a single instance.
 */

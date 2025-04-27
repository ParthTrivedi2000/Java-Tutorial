package org.allTopics.Creational.Singleton;

/*
Singleton Instance Registry in Java

This week I revisited an old classic — the Singleton Pattern — but with a fresh perspective.

Instead of writing singleton logic for every individual class (e.g., MySQLConnection, MongoDBConnection, etc.), I learned
to build a Singleton Factory — a generic, thread-safe, and reusable way to manage singleton instances using Java
Reflection & ConcurrentHashMap.

I have given a line by line explanation in the code snippet below. Please let me know in comments in case if you need any
clarifications.

public class SingletonFactory {

 // private - removes outside access
 // static - keep the map under the control of class not with object
 // final - constant unmodifiable
 // Class<?> is an unbounded generic wildcard, can support any type
 private static final ConcurrentHashMap<Class<?>, Object> instanceRegistry = new ConcurrentHashMap<>();

 // <T> declares T as generic datatype and we are using it as return type for getInstance
 public static <T> T getInstance(Class<T> clazz) {
 return (T) instanceRegistry.computeIfAbsent(clazz, SingletonFactory::createInstance);
 }

 // createInstance method creates object specific to the class type passed
 private static Object createInstance(Class<?> clazz) {
 try {
 return clazz.getDeclaredConstructor().newInstance();
 } catch (Exception e) {
 throw new RuntimeException("Cannot create instance of " + clazz.getName(), e);
 }
 }
}
 */

public class SingletonInstanceRegistry {
}

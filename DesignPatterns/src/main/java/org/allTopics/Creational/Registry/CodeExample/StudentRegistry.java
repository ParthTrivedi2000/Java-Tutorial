package org.allTopics.Creational.Registry.CodeExample;

import org.allTopics.Creational.Prototype.CodeExample.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
    private Map<String, Student> studentRegistry;

    public StudentRegistry() {
        studentRegistry = new HashMap<String, Student>();
    }

    public void add(String key, Student student) {
        studentRegistry.put(key, student);
    }

    public void remove(String key) {
        studentRegistry.remove(key);
    }

    public Student get(String key) {
        return studentRegistry.get(key).copy();
    }
}

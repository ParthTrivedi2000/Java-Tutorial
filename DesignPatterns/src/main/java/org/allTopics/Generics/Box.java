package org.allTopics;

/*
public class Box {
    private Object box;

    public Object getBox() {
        return box;
    }

    public void setBox(Object box) {
        this.box = box;
    }
}

 */


public class Box<T> {
    private T box;

    public T getBox() {
        return box;
    }

    public void setBox(T box) {
        this.box = box;
    }
}

package org.allTopics.Behavioral.Observer.NewsPaperPublisherExample.Version_02;

public abstract class NewsPaper {

    private String newsPaperName; // I want this attribute to be used by it's child classes directly hence marking
    // it as protected. (Later I changed to private and added getter method for it.

    public NewsPaper(String newsPaperName) {
        this.newsPaperName = newsPaperName;
    }
    public String getNewsPaperName() {return newsPaperName;}

}

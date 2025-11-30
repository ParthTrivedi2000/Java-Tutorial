package org.allTopics.Behavioral.Observer.NewsPaperPublisherExample.Version_01;

public class NewsPaperPublisherApp {
    public static void main(String[] args) {


        User user1 = new User("Parth");
        User user2 = new User("Prashant");
        User user3 = new User("Patrick");
        User user4 = new User("Param");
        User user5 = new User("Utsavi");

        HindustanTimes ht = new HindustanTimes("Hindustan Times");
        TimesOfIndia timesOfIndia = new TimesOfIndia("TimesOfIndia");

        // user1,2,3 subscribed for Hindustan Times
        ht.registerObserver(user1);
        ht.registerObserver(user2);
        ht.registerObserver(user3);

        // User2,4,5 subscribed for Times Of India
        timesOfIndia.registerObserver(user2);
        timesOfIndia.registerObserver(user4);
        timesOfIndia.registerObserver(user5);

        ht.notifyObservers();
        timesOfIndia.notifyObservers();


    }
}

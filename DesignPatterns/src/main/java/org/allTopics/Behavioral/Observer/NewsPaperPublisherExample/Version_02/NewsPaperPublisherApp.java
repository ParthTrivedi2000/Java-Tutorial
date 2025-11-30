package org.allTopics.Behavioral.Observer.NewsPaperPublisherExample.Version_02;

public class NewsPaperPublisherApp {
    public static void main(String[] args) {

        // 2nd Version
        User user1 = new User("Parth");
        User user2 = new User("Prashant");
        User user3 = new User("Patrick");
        User user4 = new User("Param");
        User user5 = new User("Utsavi");

        Subject hindustanTimes = new HindustanTimes();
        Subject timesOfIndia = new TimesOfIndia();

        // user1,2,3 subscribed for Hindustan Times
        hindustanTimes.registerObserver(user1);
        hindustanTimes.registerObserver(user2);
        hindustanTimes.registerObserver(user3);

        timesOfIndia.registerObserver(user4);
        timesOfIndia.registerObserver(user5);
        timesOfIndia.registerObserver(user1);

        hindustanTimes.notifyObservers();
        timesOfIndia.notifyObservers();

    }

    // Note:-
    /*
    Here I was facing an issue, since I kept hindustanTimes & timesOfIndia variables as NewsPaper typ, I was not able
    to access the registerObserver() and all those methods of Subject Interface. So I have to change it to specific
    Subject type then only I was able to access those methods.

    So in next version, providing updated design to solve this issue also. means we are implementing Subject to the
    NewsPaper class itself. see nex version.
     */
}

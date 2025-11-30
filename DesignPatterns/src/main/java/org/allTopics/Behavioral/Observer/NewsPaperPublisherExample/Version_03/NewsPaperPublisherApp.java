package org.allTopics.Behavioral.Observer.NewsPaperPublisherExample.Version_03;

public class NewsPaperPublisherApp {
    public static void main(String[] args) {

        // 3rd Version
        User user1 = new User("Parth");
        User user2 = new User("Prashant");
        User user3 = new User("Patrick");
        User user4 = new User("Param");
        User user5 = new User("Utsavi");

        NewsPaper ht = new HindustanTimes();
        NewsPaper toi = new TimesOfIndia();

        // Users are subscribing to newsPapers.
        ht.subscribe(user1);
        ht.subscribe(user2);
        ht.subscribe(user3);

        toi.subscribe(user1);
        toi.subscribe(user4);
        toi.subscribe(user5);


        // Respective NewsPapers are publishing updated News
        // Hindustan Times have published latestNews
        ht.publishNews("Breaking news from HindustanTimes!");

        // Times Of India also have some news updates. so they are also publishing now.
        toi.publishNews("Breaking news from TimesOfIndia!");

    }

}

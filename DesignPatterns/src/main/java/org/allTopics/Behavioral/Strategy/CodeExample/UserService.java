package org.allTopics.Behavioral.Strategy.CodeExample;

public class UserService {

    private EncodePasswordBehavior encodePasswordBehavior;

    public UserService(EncodePasswordBehavior epb) {
        this.encodePasswordBehavior = epb;
    }

    void register(String username, String password, String email) {
        encodePasswordBehavior.encodePassword(password);
    }
}

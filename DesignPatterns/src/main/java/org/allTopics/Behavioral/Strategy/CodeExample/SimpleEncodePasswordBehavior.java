package org.allTopics.Behavioral.Strategy.CodeExample;

public class SimpleEncodePasswordBehavior implements EncodePasswordBehavior {
    @Override
    public String encodePassword(String password) {
        String encodedPassword = password + "something";
        encodedPassword += "everything";
        return encodedPassword;
    }
}

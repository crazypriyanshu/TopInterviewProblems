package org.pdas.designPatterns.Creational.builder;

public class UserAccount {
    private final String username;
    private final String email;
    private UserAccount(Builder builder){
        this.username = builder.username;
        this.email = builder.email;
    }

    public static class Builder{
        private String username;
        private String email;

        public Builder username(String username){
            username = username;
            return this;
        }

        public Builder email(String email){
            email = email;
            return this;
        }

        public UserAccount build(){
            return new UserAccount(this);
        }
    }
}

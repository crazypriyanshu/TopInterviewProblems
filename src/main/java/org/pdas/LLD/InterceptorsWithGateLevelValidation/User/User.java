package org.pdas.LLD.InterceptorsWithGateLevelValidation.User;

import lombok.Data;
import lombok.Getter;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    private final Long id;
    private final String firstName;
    private String lastName;
    private final String email;
    private String password;
    private Set<Role> roles = new HashSet<>();
    private final Map<String, Object> attributes;

    public User(Long id, String firstName, String email, Map<String, Object> attributes){
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.attributes = attributes;
    }


}

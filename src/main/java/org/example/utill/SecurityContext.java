package org.example.utill;


import lombok.Getter;
import org.example.entity.User;


public class SecurityContext {

    private SecurityContext() {
    }

    @Getter
    private static User currentUser;



    public static void fillContext(User user) {
        currentUser = user;
    }




}

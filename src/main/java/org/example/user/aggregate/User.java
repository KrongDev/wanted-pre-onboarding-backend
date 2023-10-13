package org.example.user.aggregate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.user.command.CreateUser;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
public class User {
    //
    private String id;
    private String name;

    private long createdAt;

    public User() {
        //
        this.createdAt = System.currentTimeMillis();
    }

    public User(CreateUser createUser) {
        //
        this();

        BeanUtils.copyProperties(createUser, this);
    }
}

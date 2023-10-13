package org.example.user.service;

import lombok.RequiredArgsConstructor;
import org.example.user.aggregate.User;
import org.example.user.command.CreateUser;
import org.example.user.store.UserStore;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    //
    private final UserStore userStore;

    public String create(CreateUser command) {
        //
        String newId = UUID.randomUUID().toString();
        command.setId(newId);

        User user = new User(command);

        this.userStore.create(user);

        return user.getId();
    }
}

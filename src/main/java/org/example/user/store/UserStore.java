package org.example.user.store;

import lombok.RequiredArgsConstructor;
import org.example.user.aggregate.User;
import org.example.user.store.orm.UserJpo;
import org.example.user.store.orm.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserStore {
    //
    private final UserRepository userRepository;

    public void create(User user) {
        //
        this.userRepository.save(new UserJpo(user));
    }
}

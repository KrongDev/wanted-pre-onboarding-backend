package org.example.user.store.orm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.user.aggregate.User;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_user")
public class UserJpo {
    //
    @Id
    private String id;
    private String name;

    private long createdAt;

    public UserJpo(User user) {
        //
        BeanUtils.copyProperties(user, this);
    }

    public User toDomain() {
        User user = new User();
        BeanUtils.copyProperties(this, user);
        return user;
    }
}

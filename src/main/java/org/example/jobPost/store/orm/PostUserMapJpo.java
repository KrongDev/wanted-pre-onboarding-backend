package org.example.jobPost.store.orm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.jobPost.aggregate.PostUserMap;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_post_user_map")
public class PostUserMapJpo {
    //
    @Id
    @EmbeddedId
    private PostUserMapKey key;

    public PostUserMapJpo(PostUserMap postUserMap) {
        //
        this.key = new PostUserMapKey(postUserMap.getJobPostId(), postUserMap.getUserId());
    }

    public PostUserMap toDomain() {
        return new PostUserMap(
            this.key.jobPostId,
            this.key.userId
        );
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class PostUserMapKey implements Serializable {
        private String jobPostId;
        private String userId;
    }
}

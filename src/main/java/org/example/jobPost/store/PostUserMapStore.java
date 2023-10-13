package org.example.jobPost.store;

import lombok.RequiredArgsConstructor;
import org.example.jobPost.aggregate.PostUserMap;
import org.example.jobPost.store.orm.PostUserMapJpo;
import org.example.jobPost.store.orm.PostUserMapRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostUserMapStore {
    //
    private final PostUserMapRepository postUserMapRepository;

    public void create(PostUserMap postUserMap) {
        //
        this.postUserMapRepository.save(new PostUserMapJpo(postUserMap));
    }

    public boolean hasPostUser(PostUserMapJpo.PostUserMapKey key) {
        //
        return this.postUserMapRepository.existsById(key);
    }
}

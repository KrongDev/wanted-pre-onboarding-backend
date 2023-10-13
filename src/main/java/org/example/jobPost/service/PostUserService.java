package org.example.jobPost.service;

import lombok.RequiredArgsConstructor;
import org.example.jobPost.aggregate.PostUserMap;
import org.example.jobPost.store.PostUserMapStore;
import org.example.jobPost.store.orm.PostUserMapJpo;
import org.springframework.stereotype.Service;

import java.rmi.AlreadyBoundException;

@Service
@RequiredArgsConstructor
public class PostUserService {
    //
    private final PostUserMapStore postUserMapStore;

    public void create(String jobPostId, String userId) throws AlreadyBoundException {
        //
        if(this.postUserMapStore.hasPostUser(new PostUserMapJpo.PostUserMapKey(jobPostId, userId))) {
            throw new AlreadyBoundException(String.format("이미 존재하는 connect 입니다.\n jobPostId: %s\n userId: %s", jobPostId, userId));
        }
        PostUserMap postUserMap = new PostUserMap(jobPostId, userId);
        this.postUserMapStore.create(postUserMap);
    }
}

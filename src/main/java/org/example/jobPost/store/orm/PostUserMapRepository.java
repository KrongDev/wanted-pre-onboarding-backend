package org.example.jobPost.store.orm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostUserMapRepository extends JpaRepository<PostUserMapJpo, PostUserMapJpo.PostUserMapKey> {
}

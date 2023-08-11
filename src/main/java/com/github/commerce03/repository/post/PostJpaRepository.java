package com.github.commerce03.repository.post;

import com.github.commerce03.repository.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostJpaRepository extends JpaRepository<Post,Integer> {
    List<Post> findAllByUser(UserEntity userEntity);
}

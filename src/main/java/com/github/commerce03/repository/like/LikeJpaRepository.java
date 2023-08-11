package com.github.commerce03.repository.like;

import com.github.commerce03.repository.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeJpaRepository extends JpaRepository<Like,Integer> {

    Optional<Like> findByCommend_ComIdAndUser(Integer comId, UserEntity user);

}

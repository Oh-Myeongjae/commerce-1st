package com.github.commerce03.repository.like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeJpaRepository extends JpaRepository<Like,Integer> {

//    Optional<Like> findByCommend_com_id(Integer poId);

}
